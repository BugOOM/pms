/**

 @Name：layuiAdmin 内容系统
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


    table.render({
        elem: '#LAY-app-content-list',
        url: '/charge/findAll', //请求收费
        cols: [
            [
                { field: 'chargeType', title: '项目ID', align: 'center', width: 120 },
                { field: 'chargeName', title: '收费名称', align: 'center', width: 120 },
                { field: 'chargeThreshold', title: '收费阈值', align: 'center', width: 130 },
                { field: 'chargeLow', title: '低于阈值收费单价', align: 'center', width: 250 },
                { field: 'chargeHigh', title: '高于阈值收费单价', align: 'center', width: 250 },
                { title: '操作', minWidth: 150, align: 'center', fixed: 'right', toolbar: '#table-content-list' }
            ]
        ],
        text: '对不起，加载出现异常！'
    });

    //监听工具条
    table.on('tool(LAY-app-content-list)', function(obj) {
        var data = obj.data;
        if (obj.event === 'del') {
            layer.confirm('确定删除此文章？', function(index) {
                obj.del();
                layer.close(index);
            });
        } else if (obj.event === 'edit') {
            admin.popup({
                title: '编辑项目',
                area: ['550px', '550px'],
                id: 'LAY-popup-content-edit',
                success: function(layero, index) {
                    view(this.id).render('app/content/listform', data).done(function() {
                        form.render(null, 'layuiadmin-app-form-list');

                        //监听提交
                        form.on('submit(layuiadmin-app-form-submit)', function(data) {
                            var field = data.field; //获取提交的字段

                            //提交 Ajax 成功后，关闭当前弹层并重载表格
                            //$.ajax({});
                            $.ajax({
                                url: "/charge/update",
                                data: field,
                                type: "post",
                                dataType: "json",
                                success: function(data) {
                                    layer.msg(data.msg, {
                                        time: 1000,
                                        end: function() {
                                            layui.table.reload('LAY-app-content-list'); //重载表格
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

    //分类管理
    table.render({
        elem: '#LAY-app-content-tags',
        url: './json/content/tags.js' //模拟接口
            ,
        cols: [
            [
                { type: 'numbers', fixed: 'left' }, { field: 'id', width: 100, title: 'ID', sort: true }, { field: 'tags', title: '分类名', minWidth: 100 }, { title: '操作', width: 150, align: 'center', fixed: 'right', toolbar: '#layuiadmin-app-cont-tagsbar' }
            ]
        ],
        text: '对不起，加载出现异常！'
    });

    //监听工具条
    table.on('tool(LAY-app-content-tags)', function(obj) {
        var data = obj.data;
        if (obj.event === 'del') {
            layer.confirm('确定删除此分类？', function(index) {
                obj.del();
                layer.close(index);
            });
        } else if (obj.event === 'edit') {
            admin.popup({
                title: '编辑分类',
                area: ['450px', '200px'],
                id: 'LAY-popup-content-tags',
                success: function(layero, index) {
                    view(this.id).render('app/content/tagsform', data).done(function() {
                        form.render(null, 'layuiadmin-form-tags');

                        //监听提交
                        form.on('submit(layuiadmin-app-tags-submit)', function(data) {
                            var field = data.field; //获取提交的字段

                            //提交 Ajax 成功后，关闭当前弹层并重载表格
                            //$.ajax({});
                            layui.table.reload('LAY-app-content-tags'); //重载表格
                            layer.close(index); //执行关闭 
                        });
                    });
                }
            });
        }
    });

    //评论管理
    table.render({
        elem: '#LAY-app-content-comm',
        url: './json/content/comment.js' //模拟接口
            ,
        cols: [
            [
                { type: 'checkbox', fixed: 'left' }, { field: 'id', width: 100, title: 'ID', sort: true }, { field: 'reviewers', title: '评论者', minWidth: 100 }, { field: 'content', title: '评论内容', minWidth: 100 }, { field: 'commtime', title: '评论时间', minWidth: 100, sort: true }, { title: '操作', width: 150, align: 'center', fixed: 'right', toolbar: '#table-content-com' }
            ]
        ],
        page: true,
        limit: 10,
        limits: [10, 15, 20, 25, 30],
        text: '对不起，加载出现异常！'
    });

    //监听工具条
    table.on('tool(LAY-app-content-comm)', function(obj) {
        var data = obj.data;
        if (obj.event === 'del') {
            layer.confirm('确定删除此条评论？', function(index) {
                obj.del();
                layer.close(index);
            });
        } else if (obj.event === 'edit') {
            admin.popup({
                title: '编辑评论',
                area: ['450px', '300px'],
                id: 'LAY-popup-content-comm',
                success: function(layero, index) {
                    view(this.id).render('app/content/contform', data).done(function() {
                        form.render(null, 'layuiadmin-form-comment');

                        //监听提交
                        form.on('submit(layuiadmin-app-com-submit)', function(data) {
                            var field = data.field; //获取提交的字段

                            //提交 Ajax 成功后，关闭当前弹层并重载表格
                            //$.ajax({});
                            layui.table.reload('LAY-app-content-comm'); //重载表格
                            layer.close(index); //执行关闭 
                        });
                    });
                }
            });
        }
    });

    exports('contlist', {})
});