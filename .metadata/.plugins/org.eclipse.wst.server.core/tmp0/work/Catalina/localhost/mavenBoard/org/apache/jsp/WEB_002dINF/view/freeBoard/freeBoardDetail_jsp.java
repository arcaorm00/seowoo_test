/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-12-28 04:50:41 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.freeBoard;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class freeBoardDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html; charset=EUC-KR");
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
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=EUC-KR\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-1.12.4.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction clickDelete(){\r\n");
      out.write("\t\tvar num = $(\"#num\").val();\r\n");
      out.write("\t\tconsole.log(num);\r\n");
      out.write("\t\tvar re = confirm(\"삭제된 게시물은 복구가 불가능합니다.\\n정말로 삭제하시겠습니까?\");\r\n");
      out.write("\t\tif(re){\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\tdata: num,\r\n");
      out.write("\t\t\t\ttype: \"GET\",\r\n");
      out.write("\t\t\t\turl: \"./freeBoardDelete.ino?num=\"+num,\r\n");
      out.write("\t\t\t\tsuccess: function(data){\r\n");
      out.write("\t\t\t\t\tvar re = data.re;\r\n");
      out.write("\t\t\t\t\tvar list = data.list;\r\n");
      out.write("\t\t\t\t\tconsole.log(list);\r\n");
      out.write("\t\t\t\t\tif(re > 0){\r\n");
      out.write("\t\t\t\t\t\talert(\"게시물이 삭제되었습니다!\");\r\n");
      out.write("\t\t\t\t\t\tlocation.href=\"/mavenBoard/main.ino\";\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\talert(\"게시물 삭제에 실패했습니다!\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t}\r\n");
      out.write("\t};\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<h1>자유게시판</h1>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div style=\"width:650px;\" align=\"right\">\r\n");
      out.write("\t\t<a href=\"./main.ino\">리스트로</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<hr style=\"width: 600px\">\r\n");
      out.write("\r\n");
      out.write("<!-- \r\n");
      out.write("\t<form name=\"insertForm\">\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"num\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${freeBoardDto.num }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" />\r\n");
      out.write("\t\t<table border=\"1\">\r\n");
      out.write("\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td style=\"width: 150px;\" align=\"center\">타입 :</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"width: 400px;\">\r\n");
      out.write("\t\t\t\t\t\t<select>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"01\">자유</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"02\">익명</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"03\">QnA</option>\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td style=\"width: 150px;\"align=\"center\">이름 :</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"width: 400px;\"><input type=\"text\" name=\"name\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${freeBoardDto.name }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" readonly/></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td style=\"width: 150px;\"align=\"center\">제목 :</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"width: 400px;\"><input type=\"text\" name=\"title\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${freeBoardDto.title }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td style=\"width: 150px;\"align=\"center\">내용 :</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"width: 400px;\"><textarea name=\"content\" rows=\"25\" cols=\"65\"  >");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${freeBoardDto.content }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</tbody>\r\n");
      out.write("\t\t\t<tfoot>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t<td align=\"right\">\r\n");
      out.write("\t\t\t\t\t<input type=\"button\" value=\"수정\" onclick=\"modify()\">\r\n");
      out.write("\t\t\t\t\t<input type=\"button\" value=\"삭제\" onclick=\"location.href='./freeBoardDelete.ino?num=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${freeBoardDto.num }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'\">\r\n");
      out.write("\t\t\t\t\t<input type=\"button\" value=\"취소\" onclick=\"location.href='./main.ino'\">\r\n");
      out.write("\t\t\t\t\t&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</tfoot>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\r\n");
      out.write("\t</form>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<input type=\"hidden\" name=\"num\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${freeBoardDto.num }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" />\r\n");
      out.write("\r\n");
      out.write("\t\t<div style=\"width: 150px; float: left;\">이름 :</div>\r\n");
      out.write("\t\t<div style=\"width: 500px; float: left;\" align=\"left\"><input type=\"text\" name=\"name\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${freeBoardDto.name }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" readonly/></div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div style=\"width: 150px; float: left;\">제목 :</div>\r\n");
      out.write("\t\t<div style=\"width: 500px; float: left;\" align=\"left\"><input type=\"text\" name=\"title\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${freeBoardDto.title }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/></div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div style=\"width: 150px; float: left;\">작성날자</div>\r\n");
      out.write("\t\t<div style=\"width: 500px; float: left;\" align=\"left\"><input type=\"text\" name=\"regdate\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${freeBoardDto.regdate }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/></div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div style=\"width: 150px; float: left;\">내용 :</div>\r\n");
      out.write("\t\t<div style=\"width: 500px; float: left;\" align=\"left\"><textarea name=\"content\" rows=\"25\" cols=\"65\"  >");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${freeBoardDto.content }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea></div>\r\n");
      out.write("\t\t<div align=\"right\">\r\n");
      out.write("\t\t<input type=\"button\" value=\"수정\" onclick=\"modify()\">\r\n");
      out.write("\t\t<input type=\"button\" value=\"삭제\" onclick=\"location.href='./freeBoardDelete.ino?num=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${freeBoardDto.num }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'\">\r\n");
      out.write("\r\n");
      out.write("\t\t<input type=\"button\" value=\"취소\" onclick=\"location.href='./main.ino'\">\r\n");
      out.write("\t\t&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t</div> \r\n");
      out.write("-->\r\n");
      out.write("\r\n");
      out.write("\t<form name=\"insertForm\">\r\n");
      out.write("\t\t<input type=\"hidden\" id=\"num\" name=\"num\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ freeBoardDto.num }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" />\r\n");
      out.write("\t\t<table border=\"1\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td style=\"width: 150px;\" align=\"center\">타입 :</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"width: 400px;\"><input type=\"text\" name=\"codeType\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ freeBoardDto.codeType }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" readonly/></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td style=\"width: 150px;\"align=\"center\">이름 :</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"width: 400px;\"><input type=\"text\" name=\"name\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ freeBoardDto.name }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" readonly/></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td style=\"width: 150px;\"align=\"center\">제목 :</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"width: 400px;\"><input type=\"text\" name=\"title\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ freeBoardDto.title }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" readonly/></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td style=\"width: 150px;\"align=\"center\">작성날자</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"width: 400px;\"><input type=\"text\" name=\"regdate\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ freeBoardDto.regdate }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" readonly/></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td style=\"width: 150px;\"align=\"center\">내용 :</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"width: 400px;\"><textarea style=\"resize: none;\" name=\"content\" rows=\"25\" cols=\"65\" readonly >");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ freeBoardDto.content }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</tbody>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<tfoot>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t<td align=\"right\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"button\" value=\"수정\" onclick=\"location.href='./freeBoardModify.ino?num=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ freeBoardDto.num }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("'\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"button\" value=\"삭제\" onClick=\"clickDelete();\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"button\" value=\"취소\" onclick=\"location.href='./main.ino'\">\r\n");
      out.write("\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</tfoot>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</form>\r\n");
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
}
