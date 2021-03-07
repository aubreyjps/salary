let flag = true;
function texts() {
    console.log("demo")
    let title = $(" #title .title-left");
    let titleImg = $(" #title .title-left img");
    let footer = $("footer");
    let nav = $("#nav");
    let content = $("#content")
    if(flag) {
        title.css("padding-left","20px")
        titleImg.attr("src","../images/page_last.png")
        footer.css("padding-left","20px")
        nav.css("display","none")
        content.css("left","0px")
        flag = false
    } else {
        title.css("padding-left","300px")
        titleImg.attr("src","../images/page_first.png")
        footer.css("padding-left","300px")
        nav.css("display","block")
        content.css("left","280px")
        flag = true
    }
}