/**
 * Created by Administrator on 2017-10-15.
 */
$().ready(function(){
    $("input[name = 'allcheck']").unbind("click");
    $("input[name = 'allcheck']").bind("click",function () {
        $(this).controlCheckBox("userCheckBox")
    });
});