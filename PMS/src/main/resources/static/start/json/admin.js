{
    "code": 0,
    "msg": "",
    "data": [{
        "title": "主页",
        "icon": "layui-icon-home",
        "list": [{
            "title": "欢迎",
            "jump": "/"
        }]
    }, {
        "name": "app",
        "title": "信息管理",
        "icon": "layui-icon-app",
        "list": [{
            "name": "content",
            "title": "收费管理",
            "jump": "app/content/list"
        }, {
            "name": "workorder",
            "title": "投诉系统",
            "jump": "app/workorder/list"
        }]
    }, {
        "name": "user",
        "title": "住房管理",
        "icon": "layui-icon-user",
        "list": [{
            "name": "user",
            "title": "住户管理",
            "jump": "user/user/list"
        }, {
            "name": "administrators-list",
            "title": "收费",
            "jump": "user/administrators/list"
        }, {
            "name": "administrators-rule",
            "title": "楼栋管理",
            "jump": "user/dept/role"
        }]
    }, {
        "name": "set",
        "title": "设置",
        "icon": "layui-icon-set",
        "list": [{
            "name": "user",
            "title": "我的设置",
            "spread": true,
            "list": [{
                "name": "password",
                "title": "修改密码"
            }]
        }]
    }]
}