/**

 @Name：layuiAdmin 用户管理 管理员管理 角色管理
 @Author：star1029
 @Site：http://www.layui.com/admin/
 @License：LPPL
    
 */


layui.define(['table', 'form'], function(exports) {
    var $ = layui.$,
        admin = layui.admin,
        view = layui.view,
        table = layui.table,
        form = layui.form;

    //住户管理
    table.render({
        elem: '#LAY-user-manage',
        url: '/deptHouse/findDeptHouse',
        cols: [
            [
                { field: 'deptName', width: 120, title: '楼栋名称', align: 'center' },
                { field: 'houseNum', title: '门牌号', width: 120, align: 'center' },
                { field: 'ownerName', title: '业主姓名', width: 120, align: 'center' },
                { field: 'ownerSex', title: '业主性别', width: 120, align: 'center' },
                { field: 'ownerAge', width: 120, title: '业主年龄', align: 'center' },
                { field: 'ownerNum', title: '业主身份证号', minWidth: 150, align: 'center' },
                { field: 'ownerPhone', title: '业主电话', minWidth: 120, align: 'center' },
                { title: '操作', width: 150, align: 'center', fixed: 'right', toolbar: '#table-useradmin-webuser' }
            ]
        ],
        page: true,
        limit: 10,
        limits: [10, 15, 20, 25, 30],
        height: 'full-320',
        text: '对不起，加载出现异常！'
    });

    //监听工具条
    table.on('tool(LAY-user-manage)', function(obj) {
        var data = obj.data;
        var houseId = data.houseId;
        if (obj.event === 'del') {
            layer.prompt({
                formType: 1,
                title: '敏感操作，请验证口令'
            }, function(value, index) {
                layer.close(index);

                layer.confirm('真的删除行么', function(index) {
                    obj.del();
                    layer.close(index);
                });
            });
        } else if (obj.event === 'edit') {
            admin.popup({
                title: '添加账单',
                area: ['500px', '450px'],
                id: 'LAY-popup-user-add',
                success: function(layero, index) {
                    view(this.id).render('user/user/userform', data).done(function() {
                        form.render(null, 'layuiadmin-form-useradmin');

                        //监听提交
                        form.on('submit(LAY-user-front-submit)', function(data) {
                            var field = data.field; //获取提交的字段

                            //提交 Ajax 成功后，关闭当前弹层并重载表格
                            //$.ajax({});
                            $.ajax({
                                url: "/pay/fee",
                                data: {
                                    "houseId": houseId,
                                    "chargeType": field.chargeType,
                                    "payUse": field.payUse
                                },
                                dataType: "json",
                                type: "post",
                                success: function(data) {
                                    layer.msg(data.msg, {
                                        time: 1000,
                                        end: function() {
                                            updateSelect();
                                        }
                                    });
                                }
                            })
                            layer.close(index); //执行关闭 
                        });
                    });
                }
            });
        }
    });

    //缴费管理
    table.render({
        elem: '#LAY-user-back-manage',
        url: '/payHouse/findAll', //模拟接口
        cols: [
            [
                { field: 'payId', title: '流水号', align: 'center', sort: true },
                { field: 'deptName', title: '楼栋名', align: 'center' },
                { field: 'houseNum', title: '房间号', align: 'center' },
                { field: 'ownerId', title: '住户ID', hide: true },
                { field: 'ownerName', title: '住户名', align: 'center' },
                { field: 'ownerPhone', title: '住户电话', align: 'center' },
                { field: 'chargeName', title: '缴费项目', align: 'center' },
                { field: 'payUse', title: '使用量', align: 'center' },
                { field: 'payTotal', title: '应付', align: 'center' },
                { field: 'payTime', title: '上次缴费时间', align: 'center', templet: "<div>{{d.payTime==null?'':layui.util.toDateString(d.payTime,'yyyy-MM-dd')}}</div>" },
                { field: 'payStatus', title: '状态', templet: '#buttonTpl', width: 80, align: 'center' },
                { title: '操作', width: 80, align: 'center', fixed: 'right', toolbar: '#table-useradmin-admin' }
            ]
        ],
        page: true,
        limit: 10,
        limits: [10, 15, 20, 25, 30],
        text: '对不起，加载出现异常！'
    });

    //监听工具条
    table.on('tool(LAY-user-back-manage)', function(obj) {
        var data = obj.data;
        var payHouse = data
        if (obj.event === 'del') {
            layer.confirm('确定发邮件提醒缴费?', function(index) {
                $.ajax({
                    url: "/payHouse/remainder",
                    data: payHouse,
                    type: "post",
                    dataType: "json",
                    success: function(data) {
                        layer.msg(data.msg)
                    }
                })
                layer.close(index);
            });

        } else if (obj.event === 'edit') {
            admin.popup({
                title: '编辑管理员',
                area: ['420px', '450px'],
                id: 'LAY-popup-user-add',
                success: function(layero, index) {
                    view(this.id).render('user/administrators/adminform', data).done(function() {
                        form.render(null, 'layuiadmin-form-admin');

                        //监听提交
                        form.on('submit(LAY-user-back-submit)', function(data) {
                            var field = data.field; //获取提交的字段

                            //提交 Ajax 成功后，关闭当前弹层并重载表格
                            //$.ajax({});
                            layui.table.reload('LAY-user-back-manage'); //重载表格
                            layer.close(index); //执行关闭 
                        });
                    });
                }
            });
        }
    });

    //楼栋管理
    table.render({
        elem: '#LAY-user-back-role',
        url: '/dept/findDept',
        cols: [
            [
                { field: 'deptId', width: 80, title: '楼栋编号', sort: true, align: 'center' },
                { field: 'deptName', title: '楼栋名', align: 'center' },
                { field: 'deptFloor', title: '楼栋层数', align: 'center' },
                { field: 'deptNum', title: '每层房间数', align: 'center' },
                { field: 'deptArea', title: '面积', align: 'center' },
                { field: 'deptTime', title: '建成时间', align: 'center', templet: "<div>{{layui.util.toDateString(d.deptTime,'yyyy-MM-dd')}}</div>" }
            ]
        ],
        page: true,
        limit: 10,
        limits: [10, 15, 20, 25, 30],
        text: '对不起，加载出现异常！'
    });

    //监听工具条
    table.on('tool(LAY-user-back-role)', function(obj) {
        var data = obj.data;
        if (obj.event === 'del') {
            layer.confirm('确定删除此角色？', function(index) {
                obj.del();
                layer.close(index);
            });
        } else if (obj.event === 'edit') {
            admin.popup({
                title: '添加新角色',
                area: ['500px', '480px'],
                id: 'LAY-popup-user-add',
                success: function(layero, index) {
                    view(this.id).render('user/administrators/roleform', data).done(function() {
                        form.render(null, 'layuiadmin-form-role');

                        //监听提交
                        form.on('submit(LAY-user-role-submit)', function(data) {
                            var field = data.field; //获取提交的字段

                            //提交 Ajax 成功后，关闭当前弹层并重载表格
                            //$.ajax({});
                            layui.table.reload('LAY-user-back-role'); //重载表格
                            layer.close(index); //执行关闭 
                        });
                    });
                }
            });
        }
    });

    exports('useradmin', {})
});