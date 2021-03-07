var date = new Date();
var year = date.getFullYear();
var month = date.getMonth() + 1;
$(function () {
    var yearOpt = $("select[name='year']")
    var s = "<option value='"+year+"' selected>"+year+"</option>"
    for (var i = year-1; i >= 2018; i--) {
        s = s +"<option value='" + i + "'>" + i + "</option>"
    }
    yearOpt.append(s)
    var monthOpt = $("select[name='month']")
    s = ""
    for (var i = 1;i<=12;i++){
        if (i == month)
            s = s+"<option value='"+i+"' selected>"+i+"</option>"
        else
            s = s+"<option value='"+i+"'>"+i+"</option>"
    }
    monthOpt.append(s)
})



