/**

 @Name：layuiAdmin 工单系统
 @Author：star1029
 @Site：http://www.layui.com/admin/
 @License：GPL-2
    
 */


layui.define(['table', 'form', 'element'], function(exports) {
    var $ = layui.$,
        admin = layui.admin,
        view = layui.view,
        table = layui.table,
        form = layui.form,
        element = layui.element;

    table.render({
        elem: '#LAY-app-workorder',
        url: '/complaint/findMyComplaint', //请求所有投诉
        where: { "admin": "admin" },
        type: "post",
        cols: [
            [
                { field: 'complaintId', width: 100, title: '投诉单号', sort: true, align: 'center' },
                { field: 'complaintTitle', width: 100, title: '投诉标题', width: 100, align: 'center' },
                { field: 'complaintContent', width: 500, title: '投诉内容', align: 'center' },
                { field: 'complaintUser', width: 100, title: '提交者', align: 'center' },
                {
                    field: 'complaintTime',
                    width: 150,
                    title: '提交时间',
                    sort: true,
                    align: 'center',
                    templet: "<div>{{layui.util.toDateString(d.complaintTime,'yyyy-MM-dd')}}</div>"
                },
                { field: 'complaintStatus', title: '工单状态', templet: '#buttonTpl', minWidth: 80, align: 'center' },
                { title: '操作', align: 'center', fixed: 'right', toolbar: '#table-system-order' }
            ]
        ],
        page: true,
        limit: 10,
        limits: [10, 15, 20, 25, 30],
        text: '对不起，加载出现异常！',
        done: function() {
            element.render('progress');
        }
    });

    //监听工具条
    table.on('tool(LAY-app-workorder)', function(obj) {
        var data = obj.data;
        var complaintId = data.complaintId
        if (obj.event === 'edit') {
            admin.popup({
                title: '编辑工单',
                area: ['450px', '450px'],
                id: 'LAY-popup-workorder-add',
                success: function(layero, index) {
                    view(this.id).render('app/workorder/listform').done(function() {
                        form.render(null, 'layuiadmin-form-workorder');

                        //监听提交
                        form.on('submit(LAY-app-workorder-submit)', function(data) {
                            var field = data.field; //获取提交的字段
                            var ddd = {
                                "complaintId": complaintId,
                                "complaintStatus": field.complaintStatus
                            }

                            //提交 Ajax 成功后，关闭当前弹层并重载表格
                            //$.ajax({});
                            $.ajax({
                                url: "/complaint/handle",
                                data: ddd,
                                type: "post",
                                dataType: "json",
                                success: function(data) {
                                    layer.msg(data.msg);
                                    layui.table.reload('LAY-app-workorder'); //重载表格
                                }
                            })
                            layer.close(index); //执行关闭 
                        });
                    });
                }
            });
        }
    });

    exports('workorder', {})
});