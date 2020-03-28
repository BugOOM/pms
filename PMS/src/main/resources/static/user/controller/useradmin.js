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

    //用户管理
    table.render({
        elem: '#LAY-user-manage',
        url: '/deptHouse/findUserDeptHouse', //模拟接口,
        cols: [
            [
                { field: 'houseId', width: 170, title: '编号', sort: true, align: 'center' },
                { field: 'houseNum', title: '门牌号', align: 'center', width: 170 },
                { field: 'deptName', title: '所属楼栋', width: 170, align: 'center' },
                { field: 'deptTime', title: '完工时间', width: 170, align: 'center' },
                { field: 'deptArea', title: '面积大小', width: 170, align: 'center' },
                { title: '操作', width: 170, align: 'center', fixed: 'right', toolbar: '#table-useradmin-webuser' }
            ]
        ],
        page: true,
        limit: 10,
        limits: [10, 15, 20, 25, 30],
        text: '对不起，加载出现异常！'
    });

    //监听工具条
    table.on('tool(LAY-user-manage)', function(obj) {
        var data = obj.data;
        var houseId = data.houseId
        if (obj.event === 'del') {
            layer.confirm('确定入住了吗', function(index) {
                $.ajax({
                    url: "/house/update",
                    data: { "houseId": houseId },
                    type: "post",
                    dataType: "json",
                    success: function(data) {
                        layer.msg(data.msg, {
                            time: 1000,
                            end: function() {
                                //layui.table.reload('LAY-user-manage'); //重载表格
                                obj.del();
                            }
                        });
                    }

                })

                layer.close(index);
            });
        } else if (obj.event === 'edit') {
            admin.popup({
                title: '编辑用户',
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
                            layui.table.reload('LAY-user-manage'); //重载表格
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
        url: '/payHouse/userFindAll', //模拟接口
        cols: [
            [
                { field: 'payId', title: '流水号', align: 'center', sort: true, width: 80 },
                { field: 'deptName', title: '楼栋名', align: 'center' },
                { field: 'houseNum', title: '房间号', align: 'center' },
                { field: 'chargeName', title: '缴费项目', align: 'center' },
                { field: 'payUse', title: '使用量', align: 'center' },
                { field: 'payTotal', title: '应付', align: 'center' },
                { field: 'payTime', title: '上次缴费时间', align: 'center', templet: "<div>{{d.payTime==null?'':layui.util.toDateString(d.payTime,'yyyy-MM-dd')}}</div>" },
                { field: 'payStatus', title: '状态', templet: '#buttonTpl', width: 80, align: 'center' },
                { title: '操作', width: 100, align: 'center', fixed: 'right', toolbar: '#table-useradmin-admin' }
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
        var fee = data
        if (obj.event === 'del') {
            layer.confirm('确定缴费？', function(index) {
                $.ajax({
                    url: "/payHouse/pay",
                    data: {
                        "payId": fee.payId
                    },
                    type: "post",
                    dataType: "json",
                    success: function(data) {
                        layer.msg(data.msg, {
                            time: 1000,
                            end: function() {
                                layui.table.reload('LAY-user-back-manage'); //重载表格
                            }
                        });
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

    //角色管理
    table.render({
        elem: '#LAY-user-back-role',
        url: './json/useradmin/role.js' //模拟接口
            ,
        cols: [
            [
                { type: 'checkbox', fixed: 'left' }, { field: 'id', width: 80, title: 'ID', sort: true }, { field: 'rolename', title: '角色名' }, { field: 'limits', title: '拥有权限' }, { field: 'descr', title: '具体描述' }, { title: '操作', width: 150, align: 'center', fixed: 'right', toolbar: '#table-useradmin-admin' }
            ]
        ],
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