/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-01-15 01:00:48 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.authorityCheck;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class authorityTableMain_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".modal {\r\n");
      out.write("    display: none; /* Hidden by default */\r\n");
      out.write("    position: fixed; /* Stay in place */\r\n");
      out.write("    z-index: 1; /* Sit on top */\r\n");
      out.write("    left: 0;\r\n");
      out.write("    top: 0;\r\n");
      out.write("    width: 100%; /* Full width */\r\n");
      out.write("    height: 100%; /* Full height */\r\n");
      out.write("    overflow: auto; /* Enable scroll if needed */\r\n");
      out.write("    background-color: rgb(0,0,0); /* Fallback color */\r\n");
      out.write("    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Modal Content/Box */\r\n");
      out.write(".modal-content {\r\n");
      out.write("    background-color: #fefefe;\r\n");
      out.write("    margin: 15% auto; /* 15% from the top and centered */\r\n");
      out.write("    padding: 20px;\r\n");
      out.write("    border: 1px solid #888;\r\n");
      out.write("    width: 80%; /* Could be more or less, depending on screen size */\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* The Close Button */\r\n");
      out.write("#close {\r\n");
      out.write("    color: #aaa;\r\n");
      out.write("    float: right;\r\n");
      out.write("    font-size: 28px;\r\n");
      out.write("    font-weight: bold;\r\n");
      out.write("    margin-right: 15px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#close:hover,\r\n");
      out.write("#close:focus {\r\n");
      out.write("    color: black;\r\n");
      out.write("    text-decoration: none;\r\n");
      out.write("    cursor: pointer;\r\n");
      out.write("} \r\n");
      out.write("\r\n");
      out.write("/* Modal Header */\r\n");
      out.write(".modal-header {\r\n");
      out.write("    padding: 2px 16px;\r\n");
      out.write("    background-color: #5cb85c;\r\n");
      out.write("    color: white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Modal Body */\r\n");
      out.write(".modal-body {padding: 10px 16px 50px;}\r\n");
      out.write("\r\n");
      out.write("/* Modal Footer */\r\n");
      out.write(".modal-footer {\r\n");
      out.write("    padding: 2px 16px;\r\n");
      out.write("    background-color: #dedede;\r\n");
      out.write("    color: white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Modal Content */\r\n");
      out.write(".modal-content {\r\n");
      out.write("    position: relative;\r\n");
      out.write("    background-color: #fefefe;\r\n");
      out.write("    padding: 0;\r\n");
      out.write("    border: 1px solid #888;\r\n");
      out.write("    width: 80%;\r\n");
      out.write("    box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19);\r\n");
      out.write("    -webkit-animation-name: animatetop;\r\n");
      out.write("    -webkit-animation-duration: 0.4s;\r\n");
      out.write("    animation-name: animatetop;\r\n");
      out.write("    animation-duration: 0.4s\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Add Animation */\r\n");
      out.write("@-webkit-keyframes animatetop {\r\n");
      out.write("    from {top: -300px; opacity: 0}\r\n");
      out.write("    to {top: 0; opacity: 1}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@keyframes animatetop {\r\n");
      out.write("    from {top: -300px; opacity: 0}\r\n");
      out.write("    to {top: 0; opacity: 1}\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-2.2.1.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("var groupId = null;\r\n");
      out.write("var groupName = null;\r\n");
      out.write("var groupUseYn = null;\r\n");
      out.write("var mappingList = null;\r\n");
      out.write("\r\n");
      out.write("function showModal(id, name, useyn){\r\n");
      out.write("\t\r\n");
      out.write("\tconsole.log(id);\r\n");
      out.write("\tgroupId = id;\r\n");
      out.write("\tgroupName = name;\r\n");
      out.write("\tgroupUseYn = useyn;\r\n");
      out.write("\t\r\n");
      out.write("\tdrawTable(groupId);\r\n");
      out.write("\t\r\n");
      out.write("\t$(\"#myModal\").css(\"display\", \"block\");\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function changeRowColor(checkBox){\r\n");
      out.write("\tvar tr = $(checkBox).parents(\"tr\");\r\n");
      out.write("\t(checkBox.checked) ? tr.css(\"background\", \"#f0f0f0\") : tr.css(\"background\", \"white\");\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function drawTable(groupId){\r\n");
      out.write("\t// objList , mappingList (2중 for문)\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t\tdata: {groupId: groupId},\r\n");
      out.write("\t\turl: \"./authorityDetail.ino\",\r\n");
      out.write("\t\tsuccess: function(res){\r\n");
      out.write("\t\t\t$(\"#authorityTbody\").empty();\r\n");
      out.write("\t\t\tmappingList = res.mappingList;\r\n");
      out.write("\t\t\tvar objectList = res.objectList;\r\n");
      out.write("\r\n");
      out.write("\t\t\tfor (var i = 0 ; i < objectList.length ; i++){\r\n");
      out.write("\t\t\t\tvar objectRow = objectList[i];\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tvar tr = $(\"<tr></tr>\");\r\n");
      out.write("\t\t\t\tvar checkBox = $(\"<td style='width: 20px;' align='center'><input type='checkbox' name='objCheck' onClick='changeRowColor(this);'/></td>\");\r\n");
      out.write("\t\t\t\tvar useYn = \"\";\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tif (mappingList.length < 0) {\r\n");
      out.write("\t\t\t\t\tuseYn = \"미사용\";\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\tfor (var j = 0; j < mappingList.length; j++) {\r\n");
      out.write("\t\t\t\t\t\tif(objectRow.OBJID == mappingList[j].OBJID){\r\n");
      out.write("\t\t\t\t\t\t\tuseYn = \"사용중\";\r\n");
      out.write("\t\t\t\t\t\t\tcheckBox.find(\"input\").attr(\"checked\", \"checked\");\r\n");
      out.write("\t\t\t\t\t\t}else if (objectRow.OBJID != mappingList[j].OBJID && useYn == \"\"){\r\n");
      out.write("\t\t\t\t\t\t\tuseYn = \"미사용\";\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tvar objId = $(\"<td style='width: 160px;' align='center' class='objId'>\" + objectRow.OBJID + \"</td>\");\r\n");
      out.write("\t\t\t\tvar objName = $(\"<td style='width: 180px;' align='center' class='objName'>\" + objectRow.OBJNAME + \"</td>\");\r\n");
      out.write("\t\t\t\tvar dept = $(\"<td style='width: 100px;' align='center' class='dept'>\" + objectRow.DEPT + \"</td>\");\r\n");
      out.write("\t\t\t\tuseYn = $(\"<td style='width: 120px;' align='center' class='useYn'>\"+useYn+\"</td>\");\r\n");
      out.write("\r\n");
      out.write("\t\t\t\ttr.append(checkBox, objId, objName, dept, useYn);\r\n");
      out.write("\t\t\t\t$(\"#authorityTbody\").append(tr);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("$(function(){\r\n");
      out.write("\t\r\n");
      out.write("\t$(\"#close\").click(function(){\r\n");
      out.write("\t\t$(\"#myModal\").css(\"display\", \"none\");\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t$(\"#registerBtn\").click(function(){\r\n");
      out.write("\t\tvar insertList = [];\r\n");
      out.write("\t\tvar deleteList = [];\r\n");
      out.write("\t\tconsole.log(mappingList);\r\n");
      out.write("\t\t$(\"input[name=objCheck]\").each(function(){\r\n");
      out.write("\t\t\tvar objId = $(this).parents(\"tr\").children(\".objId\").text();\r\n");
      out.write("\t\t\tvar objName = $(this).parents(\"tr\").children(\".objName\").text();\r\n");
      out.write("\t\t\tvar dept = $(this).parents(\"tr\").children(\".dept\").text();\r\n");
      out.write("\t\t\tvar isExist = false;\r\n");
      out.write("\t\t\tvar row = {};\r\n");
      out.write("\r\n");
      out.write("\t\t\tfor (var i = 0; i < mappingList.length; i++) {\r\n");
      out.write("\t\t\t\tvar mappingRow = mappingList[i];\r\n");
      out.write("\t\t\t\tif (mappingRow.OBJID == objId){\r\n");
      out.write("\t\t\t\t\tisExist = true;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\trow = {groupId: groupId, groupName: groupName, useYn: groupUseYn, objId: objId, objName: objName, dept: dept}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif($(this).is(\":checked\") && !isExist){\r\n");
      out.write("\t\t\t\tinsertList.push(row);\r\n");
      out.write("\t\t\t}else if(!$(this).is(\":checked\") && isExist){\r\n");
      out.write("\t\t\t\tdeleteList.push(row);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tconsole.log(insertList);\r\n");
      out.write("\t\tconsole.log(deleteList);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif (insertList.length == 0 && deleteList.length == 0){\r\n");
      out.write("\t\t\talert(\"수정된 정보가 없습니다.\");\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\tvar parameterMap = {insertList: insertList, deleteList: deleteList};\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\tdata: JSON.stringify(parameterMap),\r\n");
      out.write("\t\t\t\turl: \"./registerMappingTable.ino\",\r\n");
      out.write("\t\t\t\tdatatype: \"json\",\r\n");
      out.write("\t\t\t\tasync: false,\r\n");
      out.write("\t\t\t\tcontentType: \"application/json; charset=UTF-8\",  \r\n");
      out.write("\t\t\t\ttype: \"POST\",\r\n");
      out.write("\t\t\t\ttransactional: true,\r\n");
      out.write("\t\t\t\tsuccess: function(re){\r\n");
      out.write("\t\t\t\t\tif (re){\r\n");
      out.write("\t\t\t\t\t\talert(\"저장되었습니다.\");\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\talert(\"예기치 못한 오류로 권한이 저장되지 못 했습니다.\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\tdrawTable(groupId);\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\terror: function(request, status, error){\r\n");
      out.write("\t\t\t\t\tconsole.log(status);\r\n");
      out.write("\t\t\t\t\tconsole.log(error);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<h1>그룹목록</h1>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<hr style=\"width: 600px\">\r\n");
      out.write("\t<table style=\"width: 600px;\" border=\"1\">\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>그룹 아이디</th>\r\n");
      out.write("\t\t\t\t<th>그룹이름</th>\r\n");
      out.write("\t\t\t\t<th>사용유무</th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</thead>\r\n");
      out.write("\t\t<tbody>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</tbody>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- The Modal -->\r\n");
      out.write("\t<div id=\"myModal\" class=\"modal\">\r\n");
      out.write("\t\t<!-- Modal content -->\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t<span id=\"close\">×</span>\r\n");
      out.write("\t\t  <div class=\"modal-header\">\r\n");
      out.write("\t\t    \r\n");
      out.write("\t\t    <h2>객체 목록</h2>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t  <div class=\"modal-body\">\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t    <input type=\"hidden\" id=\"code\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ code }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t\t\t<div style=\"padding-bottom: 10px;\">\r\n");
      out.write("\t\t\t\t<table style=\"background: #dedede;\">\r\n");
      out.write("\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td style=\"width: 20px;\" align=\"center\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td style=\"width: 160px;\" align=\"center\">OBJID</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td style=\"width: 180px;\" align=\"center\">OBJNAME</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td style=\"width: 100px;\" align=\"center\">DEPT</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td style=\"width: 120px;\" align=\"center\">사용여부</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<div id=\"authorityDiv\">\r\n");
      out.write("\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t<tbody id=\"authorityTbody\">\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  <div class=\"modal-footer\">\r\n");
      out.write("\t\t    <h3 id=\"registerBtn\" style=\"cursor: pointer;\">[ 저장 ]</h3>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t</div>\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/view/authorityCheck/authorityTableMain.jsp(239,3) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("nRow");
    // /WEB-INF/view/authorityCheck/authorityTableMain.jsp(239,3) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/view/authorityCheck/authorityTableMain.jsp(239,3) '${ list }'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${ list }",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t<tr align=\"center\">\r\n");
          out.write("\t\t\t\t\t<td style=\"width: 100px;\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ nRow.GROUPID }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t<td style=\"width: 100px;\"><a href=\"#\" onClick=\"showModal('");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${nRow.GROUPID}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("', '");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ nRow.GROUPNAME }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("', '");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ nRow.USEYN }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("');\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ nRow.GROUPNAME }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</a></td>\r\n");
          out.write("\t\t\t\t\t<td style=\"width: 100px;\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ nRow.USEYN }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("\t\t\t\t</tr>\r\n");
          out.write("\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}
