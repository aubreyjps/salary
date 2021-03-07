$(function () {
    var phonenum = sessionStorage.getItem("phonenum")
    var userData = sessionStorage.getItem(phonenum)
    if (userData == undefined){
        $.ajax({url:"/getData",type:"POST",data:{"phonenum":phonenum},success:function(result){
                userData = JSON.stringify(result);
                sessionStorage.setItem(phonenum,userData);
                $(".headImg").attr('src','../'+result.image)
                $(".name").text(result.name)
            }});
    }else {
        var user = JSON.parse(userData)
        $(".headImg").attr('src','../'+user.image)
        $(".name").text(user.name)
        $(":radio")[0].checked = user.sex
        $(":radio")[1].checked = !user.sex
        $(".email").text(user.email);
        $(".qq").text(user.qq);
        $(".phonenum").text(user.phonenum)

    }
})

function logout() {
    $.get("/delRedis?phonenum="+sessionStorage.getItem("phonenum"), function success(data) {
        console.log(data)
    })
    sessionStorage.clear()
}
