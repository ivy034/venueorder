function isChinese(obj){
    var reg=/^[\u0391-\uFFE5]+$/;
    if(obj!=""&&!reg.test(obj)){
        alert('必须输入中文！');
        return false;
    }
}
function sure(){
    var x;
    var r=confirm("是否确定提交？");
    if (r==true){
        alert("提交成功!");
    }
}
function isNumber(obj){
    var reg = /^[0-9]+$/;
    if(obj!=""&&!reg.test(obj)){
        alert('只能输入数字！');
        return false;
    }
}
function isEmail(){
    var x=document.forms["myForm"]["email"].value;
    var atpos=x.indexOf("@");
    var dotpos=x.lastIndexOf(".");
    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length){
        alert("不是一个有效的 e-mail 地址");
        return false;
    }
}
function isMobile(mobile)
{
    if(mobile.length==0)
    {
        alert('手机号码不能为空！');
        return false;
    }
    if(mobile.length!=11)
    {
        alert('请输入有效的手机号码，需是11位！');
        return false;
    }

    var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
    if(!myreg.test(mobile))
    {
        alert('请输入有效的手机号码！');
        return false;
    }
}
