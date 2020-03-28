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
        "name": "template",
        "title": "投诉系统",
        "icon": "layui-icon-template",
        "list": [{
            "name": "msgboard",
            "title": "投诉板",
            "jump": "template/msgboard"
        }]
    }, {
        "name": "app",
        "title": "应用",
        "icon": "layui-icon-app",
        "list": [{
            "name": "workorder",
            "title": "我的投诉",
            "jump": "app/workorder/list"
        }]
    }, {
        "name": "user",
        "title": "我的",
        "icon": "layui-icon-user",
        "list": [{
            "name": "user",
            "title": "选房",
            "jump": "user/user/list"
        }, {
            "name": "administrators-list",
            "title": "缴费",
            "jump": "user/administrators/list"
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
                "name": "info",
                "title": "基本资料"
            }, {
                "name": "password",
                "title": "修改密码"
            }]
        }]
    }]
}