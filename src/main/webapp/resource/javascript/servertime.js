/**
 * Created by livvy on 14/10/19.
 */


var ServerClock = function(s_timeMillis) {
    var delay = 1000;
    var serverTime = null;

    if (arguments.length == 0) {
        serverTime = new Date();
        delay = 0;
    } else {
        serverTime = new Date(s_timeMillis);
    }

    var clientTime = new Date();

    var diff = serverTime.getTime() - clientTime.getTime();

    return {
        setDelay: function (value) {
            this.delay = value;
        },

        getServerTime: function () {
            clientTime = new Date();
            serverTime.setTime(clientTime.getTime() + diff + delay);
            return serverTime;
        }

    }
}

Date.prototype.format = function(fmt)
{
    var o = {
        "M+" : this.getMonth()+1,                 //月份
        "d+" : this.getDate(),                    //日
        "h+" : this.getHours(),                   //小时
        "m+" : this.getMinutes(),                 //分
        "s+" : this.getSeconds(),                 //秒
        "q+" : Math.floor((this.getMonth()+3)/3), //季度
        "S"  : this.getMilliseconds()             //毫秒
    };
    if(/(y+)/.test(fmt))
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
    for(var k in o)
        if(new RegExp("("+ k +")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
    return fmt;
}
