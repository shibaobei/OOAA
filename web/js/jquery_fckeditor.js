/**
 * Created by Administrator on 2017-10-12.
 */
(function(jQuery){
    $.fckeditor = function(name){
        var oFCKeditor = new FCKeditor(name);//构造函数中的参数和textare中的name属性的值保持一致
        oFCKeditor.BasePath	= "fckeditor/" ;
        oFCKeditor.ToolbarSet = "Default";
        oFCKeditor.ReplaceTextarea() ;
    }
})(jQuery);