var curDate = new Date();
var yestdayDate = new Date(curDate.getTime() - 24*60*60*1000);
yestdayDate = yestdayDate.getFullYear() + "-" + (yestdayDate.getMonth()+1) + "-" + yestdayDate.getDate();
beginDate = yestdayDate;
endDate = yestdayDate;
$.ajax({
    type: "POST", //提交方式
    url: "http://192.168.1.111:8080/userInfoCountByTime",//注意！这里路径一定要对
    data: {
        "beginDate" : beginDate,
        "endDate" : endDate
    }, //数据，这里使用的是Json格式进行传输
    success: function (data) { //返回数据根据结果进行相应的处理
        $(".yestday-count").html(data.beginDate+' 至 '+data.endDate+':<span id="this-number">'+data.count+'</span>条');
    }
})
$.ajax({
    type: "POST", //提交方式
    url: "http://192.168.1.111:8080/userInfoByTime",//注意！这里路径一定要对
    data: {
        "beginDate" : beginDate,
        "endDate" : endDate
    }, //数据，这里使用的是Json格式进行传输
    success: function (data) { //返回数据根据结果进行相应的处理
        console.log(data);
        for(var i = 0;i < data.length;i++){
            var userInfo = data[i];
            var name = userInfo.name == ""?'无':userInfo.name;
            var time = new Date(parseInt(userInfo.time) * 1000).toLocaleString().replace(/:\d{1,2}$/,' ');
            $(".user-info>div").append('<ul class="user-info-content"><li>'+ (i+1) + '</li><li>'+ userInfo.id + '</li><li>' + name + '</li><li>' + userInfo.tel + '</li><li>' + userInfo.tag + '</li><li>' + time + '</li></ul>');
        }
    }
})
function download(){
    var beginDate = $('input[name = "beginDate"]').val();
    var endDate = $('input[name = "endDate"]').val();
    //其中一个为空时，提示不能为空
    if((beginDate == '' && endDate != '') || (beginDate != '' && endDate == '')){
        alert('(￢_￢)有一个日期为空！');
        return null;
    }
    //如果结束日期小于开始日期，提示不能小于
    if(endDate < beginDate){
        alert('(￢_￢)结束日期小于开始日期，请重新选择！');
        return null;
    }
    //都为空时默认为昨天日期
    if(beginDate == '' && endDate == ''){
        var curDate = new Date();
        var yestdayDate = new Date(curDate.getTime() - 24*60*60*1000);
        yestdayDate = yestdayDate.getFullYear() + "-" + (yestdayDate.getMonth()+1) + "-" + yestdayDate.getDate();
        beginDate = yestdayDate;
        endDate = yestdayDate;
    }
    window.location.href="http://192.168.1.111:8080/export/excel?beginDate="+beginDate+"&endDate="+endDate;

}

function query() {
    var beginDate = $('input[name = "beginDate"]').val();
    var endDate = $('input[name = "endDate"]').val();
    //其中一个为空时，提示不能为空
    if((beginDate == '' && endDate != '') || (beginDate != '' && endDate == '')){
        alert('(￢_￢)有一个日期为空！');
        return null;
    }
    //如果结束日期小于开始日期，提示不能小于
    if(endDate < beginDate){
        alert('(￢_￢)结束日期小于开始日期，请重新选择！');
        return null;
    }
    if(beginDate == '' && endDate == ''){
        var curDate = new Date();
        var yestdayDate = new Date(curDate.getTime() - 24*60*60*1000);
        yestdayDate = yestdayDate.getFullYear() + "-" + (yestdayDate.getMonth()+1) + "-" + yestdayDate.getDate();
        beginDate = yestdayDate;
        endDate = yestdayDate;
    }
    $.ajax({
        type: "POST", //提交方式
        url: "http://192.168.1.111:8080/userInfoCountByTime",//注意！这里路径一定要对
        data: {
            "beginDate" : beginDate,
            "endDate" : endDate
        }, //数据，这里使用的是Json格式进行传输
        success: function (data) { //返回数据根据结果进行相应的处理
            $(".yestday-count").html(data.beginDate+' 至 '+data.endDate+':<span id="this-number">'+data.count+'</span>条');
        }
    })
    $.ajax({
        type: "POST", //提交方式
        url: "http://192.168.1.111:8080/userInfoByTime",//注意！这里路径一定要对
        data: {
            "beginDate" : beginDate,
            "endDate" : endDate
        }, //数据，这里使用的是Json格式进行传输
        success: function (data) { //返回数据根据结果进行相应的处理
            console.log(data);
            $('.user-info-content').remove();
            for(var i = 0;i < data.length;i++){
                var userInfo = data[i];
                var name = userInfo.name == ""?'无':userInfo.name;
                var time = new Date(parseInt(userInfo.time) * 1000).toLocaleString().replace(/:\d{1,2}$/,' ');
                $(".user-info>div").append('<ul class="user-info-content"><li>'+ (i+1) + '</li><li>'+ userInfo.id + '</li><li>' + name + '</li><li>' + userInfo.tel + '</li><li>' + userInfo.tag + '</li><li>' + time + '</li></ul>');
            }
        }
    })
}

