/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-01-12 06:05:41 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.commonCode;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class commonCodeDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      out.write("<script src=\"https://code.jquery.com/jquery-2.2.1.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function(){\r\n");
      out.write("\tvar code = $(\"#code\").val();\r\n");
      out.write("\tvar round = 0;\r\n");
      out.write("\t\r\n");
      out.write("\t// 추가\r\n");
      out.write("\t$(\"#addBtn\").click(function(){\r\n");
      out.write("\t\t$(\"#registerBtn\").attr(\"disabled\", false);\r\n");
      out.write("\t\tif (round < 3){\r\n");
      out.write("\t\t\tvar form = $(\"<form name='codeForm'  onsubmit='return false'></form>\");\r\n");
      out.write("\t\t\tvar flag = $(\"<input type='hidden' name='FLAG' value='I'/>\");\r\n");
      out.write("\t\t\tvar checkbox = $(\"<input type='checkbox' name='codeCheck' disabled='disabled' checked/>\");\r\n");
      out.write("\t\t\tvar mastercode = $(\"<input type='text' style='width: 100px; margin-left: 6px;' name='CODE' value='\"+code+\"' readonly/>\");\r\n");
      out.write("\t\t\tvar detailcode = $(\"<input type='text' style='width: 170px; margin-left: 6px;' name='DECODE'/>\");\r\n");
      out.write("\t\t\tvar decodename = $(\"<input type='text' style='width: 170px; margin-left: 6px;' name='DECODE_NAME'/>\");\r\n");
      out.write("\t\t\tvar useyn = $(\"<span style='display: inline-block; width: 100px; margin-left: 11px; margin-right: 9px;'>\"\r\n");
      out.write("\t\t\t+\"<input type='radio' name='USE_YN' value='Y'/>Y<input type='radio' name='USE_YN' value='N'/>N</span>\");\r\n");
      out.write("\t\t\tform.append(flag, checkbox, mastercode, detailcode, decodename, useyn);\r\n");
      out.write("\t\t\t$(\"#codeBoard\").append(form);\r\n");
      out.write("\t\t\tround += 1;\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\talert(\"한번에 입력할 수 있는 코드는 최대 3개입니다.\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t// 수정\r\n");
      out.write("\t$(\"#updateBtn\").click(function(){\r\n");
      out.write("\t\t$(\"input[name='codeCheck']:checked\").parent().each(function(){\r\n");
      out.write("\t\t\tif($(this).children(\"input[name='FLAG']\").val() == \"I\" || $(this).children(\"input[name='FLAG']\").val() == \"D\"){\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tvar decodename = $(this).children(\"input[name='DECODE_NAME']\");\r\n");
      out.write("\t\t\tvar useyn = $(this).find(\"input[name='USE_YN']\");\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t/*\r\n");
      out.write("\t\t\tvar useynValue = null;\r\n");
      out.write("\t\t\tif ($(this).children(\"span\").length <= 0){\r\n");
      out.write("\t\t\t\tconsole.log(useyn.val());\r\n");
      out.write("\t\t\t\tuseynValue = useyn.val();\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\t// 해결은 했는데 왜 $(this).children(\"input[name='USE_YN']:checked\").val()은 undefined인지 이해 못함\r\n");
      out.write("\t\t\t\tconsole.log($(this).children(\"span\").children(\"input[name='USE_YN']:checked\").val());\t\t\r\n");
      out.write("\t\t\t\tuseynValue = $(this).children(\"span\").children(\"input[name='USE_YN']:checked\").val();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar newUseYn = null;\r\n");
      out.write("\t\t\tif (useynValue == \"Y\"){\r\n");
      out.write("\t\t\t\tnewUseYn = $(\"<span style='display: inline-block; width: 100px; margin-right: 8px;'><input type='radio' name='USE_YN' value='Y' checked/>Y<input type='radio' name='USE_YN' value='N'/>N</span>\");\r\n");
      out.write("\t\t\t}else if (useynValue == \"N\"){\r\n");
      out.write("\t\t\t\tnewUseYn = $(\"<span style='display: inline-block; width: 100px; margin-right: 8px;'><input type='radio' name='USE_YN' value='Y'/>Y<input type='radio' name='USE_YN' value='N' checked/>N</span>\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tuseyn.remove();\r\n");
      out.write("\t\t\t$(this).children(\"span\").remove();\r\n");
      out.write("\t\t\t$(this).append(newUseYn);\r\n");
      out.write("\t\t\t*/\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar flag = $(\"<input type='hidden' name='FLAG' value='U'/>\");\r\n");
      out.write("\t\t\tif ($(this).children(\"input[name='FLAG']\").length <= 0){\r\n");
      out.write("\t\t\t\t$(this).append(flag);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\tdecodename.attr(\"disabled\", false);\r\n");
      out.write("\t\t\tuseyn.attr(\"disabled\", false);\r\n");
      out.write("\t\t\t$(\"#registerBtn\").attr(\"disabled\", false);\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t// 삭제\r\n");
      out.write("\t$(\"#deleteBtn\").click(function(){\r\n");
      out.write("\t\t$(\"input[name='codeCheck']:checked\").parent().each(function(){\r\n");
      out.write("\t\t\tif($(this).children(\"input[name='FLAG']\").length > 0){\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t$(this).find(\"input[name='FLAG']\").remove();\r\n");
      out.write("\t\t\tvar flag = $(\"<input type='hidden' name='FLAG' value='D'/>\");\r\n");
      out.write("\t\t\t$(this).append(flag);\r\n");
      out.write("\t\t\t$(this).children().css(\"text-decoration\", \"line-through\");\r\n");
      out.write("\t\t\t$(\"#registerBtn\").attr(\"disabled\", false);\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tvar confirmed = false;\r\n");
      out.write("\t$(\"#registerBtn\").click(function(){\r\n");
      out.write("\t\tvar codeList = [];\r\n");
      out.write("\t\tvar duplicated = \"\";\r\n");
      out.write("\t\tvar msg = \"\";\r\n");
      out.write("\t\tvar cnt = $(\"input[name='codeCheck']:checked\").parent().length;\r\n");
      out.write("\t\tconfirmed = false;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//$(\"form[name='codeForm']\").each(function(){\r\n");
      out.write("\t\t$(\"input[name='codeCheck']:checked\").parent().each(function(){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar detailcode = $(this).children(\"input[name='DECODE']\").val().trim();\r\n");
      out.write("\t\t\tvar decodename = $(this).children(\"input[name='DECODE_NAME']\").val().trim();\r\n");
      out.write("\t\t\tvar useyn = $(this).find(\"input[name='USE_YN']:checked\").val();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$(this).children(\"input[name='CODE']\").attr(\"disabled\", false);\r\n");
      out.write("\t\t\t$(this).children(\"input[name='DECODE']\").attr(\"disabled\", false);\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tconsole.log(detailcode + \"/\" + decodename + \"/\" + useyn);\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// 입력 확인\r\n");
      out.write("\t\t\tif(detailcode == \"\" || decodename == \"\" || useyn == undefined){\r\n");
      out.write("\t\t\t\tmsg = \"입력이 완료되지 않은 행이 있습니다.\";\r\n");
      out.write("\t\t\t\tconfirmed = false;\r\n");
      out.write("\t\t\t}else if(detailcode == duplicated){\r\n");
      out.write("\t\t\t\tmsg = \"세부 코드에 중복되는 값을 입력했습니다.\";\r\n");
      out.write("\t\t\t\tconfirmed = false;\r\n");
      out.write("\t\t\t}else {\r\n");
      out.write("\t\t\t\tcnt -= 1;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tduplicated = detailcode;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar formData = $(this).serializeObject();\r\n");
      out.write("\t\t\tcodeList.push(formData);\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif ($(this).children(\"input[name='FLAG']\").val() != \"I\"){\r\n");
      out.write("\t\t\t\t$(this).children(\"input[name='CODE']\").attr(\"disabled\", true);\r\n");
      out.write("\t\t\t\t$(this).children(\"input[name='DECODE']\").attr(\"disabled\", true);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif (cnt == 0){\r\n");
      out.write("\t\t\tconfirmed = true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif (confirmed){\r\n");
      out.write("\t\t\tconsole.log(codeList);\r\n");
      out.write("\t\t\tvar list = JSON.stringify(codeList);\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// 중복 확인\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\tdata: list,\r\n");
      out.write("\t\t\t\turl: \"./detailCodeIsExist.ino\",\r\n");
      out.write("\t\t\t\tasync: false,\r\n");
      out.write("\t\t\t\tdatatype: \"json\",\r\n");
      out.write("\t\t\t\tcontentType: \"application/json; charset=UTF-8\",  \r\n");
      out.write("\t\t\t\ttype: \"POST\",\r\n");
      out.write("\t\t\t\tsuccess: function(re){\r\n");
      out.write("\t\t\t\t\tconfirmed = false;\r\n");
      out.write("\t\t\t\t\tif(re > 0){\r\n");
      out.write("\t\t\t\t\t\talert(\"세부 코드는 중복될 수 없습니다.\\n다시 한번 확인해주시기 바랍니다.\");\r\n");
      out.write("\t\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\tconfirmed = true;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\terror: function(request, status, error){\r\n");
      out.write("\t\t\t\t\tconsole.log(status);\r\n");
      out.write("\t\t\t\t\tconsole.log(error);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tconsole.log(\"----------- list ------------\");\r\n");
      out.write("\t\t\tconsole.log(list);\r\n");
      out.write("\t\t\tconsole.log(\"confirmed:: \" + confirmed);\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif(confirmed){\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\tdata: list,\r\n");
      out.write("\t\t\t\t\turl: \"./registerDetailCode.ino\",\r\n");
      out.write("\t\t\t\t\tdatatype: \"json\",\r\n");
      out.write("\t\t\t\t\tcontentType: \"application/json; charset=UTF-8\",  \r\n");
      out.write("\t\t\t\t\ttype: \"POST\",\r\n");
      out.write("\t\t\t\t\ttransactional: true,\r\n");
      out.write("\t\t\t\t\tsuccess: function(re){\r\n");
      out.write("\t\t\t\t\t\tif(re){\r\n");
      out.write("\t\t\t\t\t\t\talert(\"코드가 정상적으로 등록되었습니다.\");\r\n");
      out.write("\t\t\t\t\t\t\tlocation.reload();\r\n");
      out.write("\t\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t\talert(\"예기치 못한 오류로 코드가 등록되지 못 했습니다.\");\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\terror: function(request, status, error){\r\n");
      out.write("\t\t\t\t\t\tconsole.log(status);\r\n");
      out.write("\t\t\t\t\t\tconsole.log(error);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\talert(msg);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("var list = [];\r\n");
      out.write("\r\n");
      out.write("$.fn.serializeObject = function() {\r\n");
      out.write("    var obj = null;\r\n");
      out.write("    try {\r\n");
      out.write("    \t\r\n");
      out.write("        if (this[0].tagName && this[0].tagName.toUpperCase() == \"FORM\") {\r\n");
      out.write("            var arr = this.serializeArray();\r\n");
      out.write("            if (arr) {\r\n");
      out.write("            \tobj = {};\r\n");
      out.write("                $.each(arr, function(idx, input) {\r\n");
      out.write("\t\t\t\t\tobj[this.name] = this.value;\r\n");
      out.write("                });\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    } catch (e) {\r\n");
      out.write("        alert(e.message);\r\n");
      out.write("    } finally {\r\n");
      out.write("    }\r\n");
      out.write("    return obj;\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"bodyAll\" align=\"center\" style=\"width: 800px;\">\r\n");
      out.write("\t\t<div class=\"contents\" style=\"width: 800px; margin: 0;\">\r\n");
      out.write("               <div style=\"background-color:#dedede; height:700px; padding: 20px;\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t<h1>세부 코드 등록</h1>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" id=\"code\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ code }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t\t\t\t<div style=\"width:650px;\" align=\"right\">\r\n");
      out.write("\t\t\t\t\t<button id=\"addBtn\" name=\"addBtn\">추가</button>\r\n");
      out.write("\t\t\t\t\t<button id=\"updateBtn\" name=\"updateBtn\">수정</button>\r\n");
      out.write("\t\t\t\t\t<button id=\"deleteBtn\" name=\"deleteBtn\">삭제</button>\r\n");
      out.write("\t\t\t\t\t<button id=\"registerBtn\" name=\"registerBtn\" disabled>등록</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<hr style=\"width: 600px;\">\r\n");
      out.write("\t\t\t\t<div style=\"padding-bottom: 10px;\">\r\n");
      out.write("\t\t\t\t\t<table border=\"1\">\r\n");
      out.write("\t\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td style=\"width: 20px;\" align=\"center\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td style=\"width: 100px;\" align=\"center\">기준 코드</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td style=\"width: 180px;\" align=\"center\">세부 코드</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td style=\"width: 180px;\" align=\"center\">코드 이름</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td style=\"width: 100px;\" align=\"center\">사용여부</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<hr style=\"width: 600px;\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<div id=\"codeBoard\">\r\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t </div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
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
    // /WEB-INF/view/commonCode/commonCodeDetail.jsp(260,5) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("nRow");
    // /WEB-INF/view/commonCode/commonCodeDetail.jsp(260,5) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/view/commonCode/commonCodeDetail.jsp(260,5) '${ list }'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${ list }",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t<form name=\"codeForm\" onsubmit=\"return false\">\r\n");
          out.write("\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"codeCheck\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ nRow.DECODE }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\"/>\r\n");
          out.write("\t\t\t\t\t\t\t<input type='text' style='width: 100px;' name='CODE' value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ nRow.CODE }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\" disabled=\"disabled\"/>\r\n");
          out.write("\t\t\t\t\t\t\t<input type='text' style='width: 170px;' name='DECODE' value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ nRow.DECODE }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\" disabled=\"disabled\"/>\r\n");
          out.write("\t\t\t\t\t\t\t<input type='text' style='width: 170px;' name='DECODE_NAME' value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ nRow.DECODE_NAME }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\" disabled=\"disabled\"/>\r\n");
          out.write("\t\t\t\t\t\t\t<!-- <input type='text' style='width: 100px;' name='USE_YN' value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ nRow.USE_YN }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\" disabled=\"disabled\"/>-->\r\n");
          out.write("\t\t\t\t\t\t\t<span style='display: inline-block; width: 100px; margin-left: 6px; margin-right: 8px;'>\r\n");
          out.write("\t\t\t\t\t\t\t\t<input type='radio' name='USE_YN' value='Y' ");
          if (_jspx_meth_c_005fif_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write(" disabled=\"disabled\"/>Y\r\n");
          out.write("\t\t\t\t\t\t\t\t<input type='radio' name='USE_YN' value='N' ");
          if (_jspx_meth_c_005fif_005f1(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write(" disabled=\"disabled\"/>N\r\n");
          out.write("\t\t\t\t\t\t\t</span>\r\n");
          out.write("\t\t\t\t\t\t</form>\r\n");
          out.write("\t\t\t\t\t");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /WEB-INF/view/commonCode/commonCodeDetail.jsp(268,52) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ nRow.USE_YN eq 'Y' }", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("checked");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /WEB-INF/view/commonCode/commonCodeDetail.jsp(269,52) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ nRow.USE_YN eq 'N' }", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("checked");
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }
}
