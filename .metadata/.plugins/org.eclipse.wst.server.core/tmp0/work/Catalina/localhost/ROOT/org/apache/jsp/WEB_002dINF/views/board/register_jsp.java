/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.43
 * Generated at: 2021-05-02 06:14:41 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(5);
    _jspx_dependants.put("jar:file:/Users/zzun_ho9/Programing/Spring/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ex03/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("jar:file:/Users/zzun_ho9/Programing/Spring/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ex03/WEB-INF/lib/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1609769295640L));
    _jspx_dependants.put("/includes/footer.jsp", Long.valueOf(1617147505000L));
    _jspx_dependants.put("/includes/header.jsp", Long.valueOf(1619934614000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <meta name=\"description\" content=\"\">\n");
      out.write("    <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("    <title>Board - duffy</title>\n");
      out.write("\n");
      out.write("    <!-- Bootstrap Core CSS -->\n");
      out.write("    <link href=\"/resources/vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- MetisMenu CSS -->\n");
      out.write("    <link href=\"/resources/vendor/metisMenu/metisMenu.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- DataTables CSS -->\n");
      out.write("    <link href=\"/resources/vendor/datatables-plugins/dataTables.bootstrap.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- DataTables Responsive CSS -->\n");
      out.write("    <link href=\"/resources/vendor/datatables-responsive/dataTables.responsive.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Custom CSS -->\n");
      out.write("    <link href=\"/resources/dist/css/sb-admin-2.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Custom Fonts -->\n");
      out.write("    <link href=\"/resources/vendor/font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("\n");
      out.write("    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->\n");
      out.write("    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\n");
      out.write("    <!--[if lt IE 9]>\n");
      out.write("        <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\n");
      out.write("        <script src=\"https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js\"></script>\n");
      out.write("    <![endif]-->\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    <div id=\"wrapper\">\n");
      out.write("\n");
      out.write("        <!-- Navigation -->\n");
      out.write("        <nav class=\"navbar navbar-default navbar-static-top\" role=\"navigation\" style=\"margin-bottom: 0\">\n");
      out.write("            <div class=\"navbar-header\">\n");
      out.write("                <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\n");
      out.write("                    <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                </button>\n");
      out.write("                <a class=\"navbar-brand\" href=\"index.html\">SB Admin v2.0</a>\n");
      out.write("            </div>\n");
      out.write("            <!-- /.navbar-header -->\n");
      out.write("\n");
      out.write("            <ul class=\"nav navbar-top-links navbar-right\">\n");
      out.write("                <li class=\"dropdown\">\n");
      out.write("                    <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">\n");
      out.write("                        <i class=\"fa fa-envelope fa-fw\"></i> <i class=\"fa fa-caret-down\"></i>\n");
      out.write("                    </a>\n");
      out.write("                    <ul class=\"dropdown-menu dropdown-messages\">\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"#\">\n");
      out.write("                                <div>\n");
      out.write("                                    <strong>John Smith</strong>\n");
      out.write("                                    <span class=\"pull-right text-muted\">\n");
      out.write("                                        <em>Yesterday</em>\n");
      out.write("                                    </span>\n");
      out.write("                                </div>\n");
      out.write("                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"divider\"></li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"#\">\n");
      out.write("                                <div>\n");
      out.write("                                    <strong>John Smith</strong>\n");
      out.write("                                    <span class=\"pull-right text-muted\">\n");
      out.write("                                        <em>Yesterday</em>\n");
      out.write("                                    </span>\n");
      out.write("                                </div>\n");
      out.write("                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"divider\"></li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"#\">\n");
      out.write("                                <div>\n");
      out.write("                                    <strong>John Smith</strong>\n");
      out.write("                                    <span class=\"pull-right text-muted\">\n");
      out.write("                                        <em>Yesterday</em>\n");
      out.write("                                    </span>\n");
      out.write("                                </div>\n");
      out.write("                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"divider\"></li>\n");
      out.write("                        <li>\n");
      out.write("                            <a class=\"text-center\" href=\"#\">\n");
      out.write("                                <strong>Read All Messages</strong>\n");
      out.write("                                <i class=\"fa fa-angle-right\"></i>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                    <!-- /.dropdown-messages -->\n");
      out.write("                </li>\n");
      out.write("                <!-- /.dropdown -->\n");
      out.write("                <li class=\"dropdown\">\n");
      out.write("                    <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">\n");
      out.write("                        <i class=\"fa fa-tasks fa-fw\"></i> <i class=\"fa fa-caret-down\"></i>\n");
      out.write("                    </a>\n");
      out.write("                    <ul class=\"dropdown-menu dropdown-tasks\">\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"#\">\n");
      out.write("                                <div>\n");
      out.write("                                    <p>\n");
      out.write("                                        <strong>Task 1</strong>\n");
      out.write("                                        <span class=\"pull-right text-muted\">40% Complete</span>\n");
      out.write("                                    </p>\n");
      out.write("                                    <div class=\"progress progress-striped active\">\n");
      out.write("                                        <div class=\"progress-bar progress-bar-success\" role=\"progressbar\" aria-valuenow=\"40\" aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width: 40%\">\n");
      out.write("                                            <span class=\"sr-only\">40% Complete (success)</span>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"divider\"></li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"#\">\n");
      out.write("                                <div>\n");
      out.write("                                    <p>\n");
      out.write("                                        <strong>Task 2</strong>\n");
      out.write("                                        <span class=\"pull-right text-muted\">20% Complete</span>\n");
      out.write("                                    </p>\n");
      out.write("                                    <div class=\"progress progress-striped active\">\n");
      out.write("                                        <div class=\"progress-bar progress-bar-info\" role=\"progressbar\" aria-valuenow=\"20\" aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width: 20%\">\n");
      out.write("                                            <span class=\"sr-only\">20% Complete</span>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"divider\"></li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"#\">\n");
      out.write("                                <div>\n");
      out.write("                                    <p>\n");
      out.write("                                        <strong>Task 3</strong>\n");
      out.write("                                        <span class=\"pull-right text-muted\">60% Complete</span>\n");
      out.write("                                    </p>\n");
      out.write("                                    <div class=\"progress progress-striped active\">\n");
      out.write("                                        <div class=\"progress-bar progress-bar-warning\" role=\"progressbar\" aria-valuenow=\"60\" aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width: 60%\">\n");
      out.write("                                            <span class=\"sr-only\">60% Complete (warning)</span>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"divider\"></li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"#\">\n");
      out.write("                                <div>\n");
      out.write("                                    <p>\n");
      out.write("                                        <strong>Task 4</strong>\n");
      out.write("                                        <span class=\"pull-right text-muted\">80% Complete</span>\n");
      out.write("                                    </p>\n");
      out.write("                                    <div class=\"progress progress-striped active\">\n");
      out.write("                                        <div class=\"progress-bar progress-bar-danger\" role=\"progressbar\" aria-valuenow=\"80\" aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width: 80%\">\n");
      out.write("                                            <span class=\"sr-only\">80% Complete (danger)</span>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"divider\"></li>\n");
      out.write("                        <li>\n");
      out.write("                            <a class=\"text-center\" href=\"#\">\n");
      out.write("                                <strong>See All Tasks</strong>\n");
      out.write("                                <i class=\"fa fa-angle-right\"></i>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                    <!-- /.dropdown-tasks -->\n");
      out.write("                </li>\n");
      out.write("                <!-- /.dropdown -->\n");
      out.write("                <li class=\"dropdown\">\n");
      out.write("                    <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">\n");
      out.write("                        <i class=\"fa fa-bell fa-fw\"></i> <i class=\"fa fa-caret-down\"></i>\n");
      out.write("                    </a>\n");
      out.write("                    <ul class=\"dropdown-menu dropdown-alerts\">\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"#\">\n");
      out.write("                                <div>\n");
      out.write("                                    <i class=\"fa fa-comment fa-fw\"></i> New Comment\n");
      out.write("                                    <span class=\"pull-right text-muted small\">4 minutes ago</span>\n");
      out.write("                                </div>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"divider\"></li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"#\">\n");
      out.write("                                <div>\n");
      out.write("                                    <i class=\"fa fa-twitter fa-fw\"></i> 3 New Followers\n");
      out.write("                                    <span class=\"pull-right text-muted small\">12 minutes ago</span>\n");
      out.write("                                </div>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"divider\"></li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"#\">\n");
      out.write("                                <div>\n");
      out.write("                                    <i class=\"fa fa-envelope fa-fw\"></i> Message Sent\n");
      out.write("                                    <span class=\"pull-right text-muted small\">4 minutes ago</span>\n");
      out.write("                                </div>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"divider\"></li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"#\">\n");
      out.write("                                <div>\n");
      out.write("                                    <i class=\"fa fa-tasks fa-fw\"></i> New Task\n");
      out.write("                                    <span class=\"pull-right text-muted small\">4 minutes ago</span>\n");
      out.write("                                </div>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"divider\"></li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"#\">\n");
      out.write("                                <div>\n");
      out.write("                                    <i class=\"fa fa-upload fa-fw\"></i> Server Rebooted\n");
      out.write("                                    <span class=\"pull-right text-muted small\">4 minutes ago</span>\n");
      out.write("                                </div>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"divider\"></li>\n");
      out.write("                        <li>\n");
      out.write("                            <a class=\"text-center\" href=\"#\">\n");
      out.write("                                <strong>See All Alerts</strong>\n");
      out.write("                                <i class=\"fa fa-angle-right\"></i>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                    <!-- /.dropdown-alerts -->\n");
      out.write("                </li>\n");
      out.write("                <!-- /.dropdown -->\n");
      out.write("                <li class=\"dropdown\">\n");
      out.write("                    <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">\n");
      out.write("                        <i class=\"fa fa-user fa-fw\"></i> <i class=\"fa fa-caret-down\"></i>\n");
      out.write("                    </a>\n");
      out.write("                    <ul class=\"dropdown-menu dropdown-user\">\n");
      out.write("                        <li><a href=\"#\"><i class=\"fa fa-user fa-fw\"></i> User Profile</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li><a href=\"#\"><i class=\"fa fa-gear fa-fw\"></i> Settings</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"divider\"></li>\n");
      out.write("                        <li><a href=\"login.html\"><i class=\"fa fa-sign-out fa-fw\"></i> Logout</a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                    <!-- /.dropdown-user -->\n");
      out.write("                </li>\n");
      out.write("                <!-- /.dropdown -->\n");
      out.write("            </ul>\n");
      out.write("            <!-- /.navbar-top-links -->\n");
      out.write("\n");
      out.write("            <div class=\"navbar-default sidebar\" role=\"navigation\">\n");
      out.write("                <div class=\"sidebar-nav navbar-collapse\">\n");
      out.write("                    <ul class=\"nav\" id=\"side-menu\">\n");
      out.write("                        <li class=\"sidebar-search\">\n");
      out.write("                            <div class=\"input-group custom-search-form\">\n");
      out.write("                                <input type=\"text\" class=\"form-control\" placeholder=\"Search...\">\n");
      out.write("                                <span class=\"input-group-btn\">\n");
      out.write("                                <button class=\"btn btn-default\" type=\"button\">\n");
      out.write("                                    <i class=\"fa fa-search\"></i>\n");
      out.write("                                </button>\n");
      out.write("                            </span>\n");
      out.write("                            </div>\n");
      out.write("                            <!-- /input-group -->\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"index.html\"><i class=\"fa fa-dashboard fa-fw\"></i> Dashboard</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"#\"><i class=\"fa fa-bar-chart-o fa-fw\"></i> Charts<span class=\"fa arrow\"></span></a>\n");
      out.write("                            <ul class=\"nav nav-second-level\">\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"flot.html\">Flot Charts</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"morris.html\">Morris.js Charts</a>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                            <!-- /.nav-second-level -->\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"tables.html\"><i class=\"fa fa-table fa-fw\"></i> Tables</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"forms.html\"><i class=\"fa fa-edit fa-fw\"></i> Forms</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"#\"><i class=\"fa fa-wrench fa-fw\"></i> UI Elements<span class=\"fa arrow\"></span></a>\n");
      out.write("                            <ul class=\"nav nav-second-level\">\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"panels-wells.html\">Panels and Wells</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"buttons.html\">Buttons</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"notifications.html\">Notifications</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"typography.html\">Typography</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"icons.html\"> Icons</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"grid.html\">Grid</a>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                            <!-- /.nav-second-level -->\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"#\"><i class=\"fa fa-sitemap fa-fw\"></i> Multi-Level Dropdown<span class=\"fa arrow\"></span></a>\n");
      out.write("                            <ul class=\"nav nav-second-level\">\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"#\">Second Level Item</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"#\">Second Level Item</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"#\">Third Level <span class=\"fa arrow\"></span></a>\n");
      out.write("                                    <ul class=\"nav nav-third-level\">\n");
      out.write("                                        <li>\n");
      out.write("                                            <a href=\"#\">Third Level Item</a>\n");
      out.write("                                        </li>\n");
      out.write("                                        <li>\n");
      out.write("                                            <a href=\"#\">Third Level Item</a>\n");
      out.write("                                        </li>\n");
      out.write("                                        <li>\n");
      out.write("                                            <a href=\"#\">Third Level Item</a>\n");
      out.write("                                        </li>\n");
      out.write("                                        <li>\n");
      out.write("                                            <a href=\"#\">Third Level Item</a>\n");
      out.write("                                        </li>\n");
      out.write("                                    </ul>\n");
      out.write("                                    <!-- /.nav-third-level -->\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                            <!-- /.nav-second-level -->\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"#\"><i class=\"fa fa-files-o fa-fw\"></i> Sample Pages<span class=\"fa arrow\"></span></a>\n");
      out.write("                            <ul class=\"nav nav-second-level\">\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"blank.html\">Blank Page</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"login.html\">Login Page</a>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                            <!-- /.nav-second-level -->\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("                <!-- /.sidebar-collapse -->\n");
      out.write("            </div>\n");
      out.write("            <!-- /.navbar-static-side -->\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <div id=\"page-wrapper\">");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"row\">\n");
      out.write("\t<div class=\"col-lg-12\">\n");
      out.write("\t\t<h1 class=\"page-header\">Board Register</h1>\n");
      out.write("\t</div>\n");
      out.write("\t<!-- /.col-lg-12 -->\n");
      out.write("</div>\n");
      out.write("<!-- /.row -->\n");
      out.write("<div class=\"row\">\n");
      out.write("\t<div class=\"col-lg-12\">\n");
      out.write("\t\t<div class=\"panel panel-default\">\n");
      out.write("\t\t\t<div class=\"panel-heading\">Board Register</div>\n");
      out.write("\t\t\t<!-- /.panel-heading -->\n");
      out.write("\t\t\t<div class=\"panel-body\">\n");
      out.write("\t\t\t\t<form action=\"/board/register\" method=\"POST\">\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t<label for=\"exampleFormControlInput1\">Title</label> \n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"exampleFormControlInput1\" name=\"title\" placeholder=\"Input title\">\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t<label for=\"exampleFormControlInput1\">Writer</label> \n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"exampleFormControlInput1\" name=\"writer\" placeholder=\"Input writer\">\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t\t\t<label for=\"exampleFormControlTextarea1\">Context</label>\n");
      out.write("\t\t\t\t\t\t<textarea class=\"form-control\" id=\"exampleFormControlTextarea1\" name=\"context\" rows=\"3\" placeholder=\"Input context\"></textarea>\n");
      out.write("\t\t\t\t\t  </div>\n");
      out.write("\t\t\t\t\t  <button type=\"submit\" class=\"btn btn-primary\">Submit</button>\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn list btn-secondary\">List</button>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<!-- /.panel-body -->\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!-- /.panel -->\n");
      out.write("\t</div>\n");
      out.write("\t<!-- /.col-lg-12 -->\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("      </div>\n");
      out.write("        <!-- /#page-wrapper -->\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <!-- /#wrapper -->\n");
      out.write("\n");
      out.write("    <!-- jQuery -->\n");
      out.write("    <script src=\"/resources/vendor/jquery/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- Bootstrap Core JavaScript -->\n");
      out.write("    <script src=\"/resources/vendor/bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- Metis Menu Plugin JavaScript -->\n");
      out.write("    <script src=\"/resources/vendor/metisMenu/metisMenu.min.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- DataTables JavaScript -->\n");
      out.write("    <script src=\"/resources/vendor/datatables/js/jquery.dataTables.min.js\"></script>\n");
      out.write("    <script src=\"/resources/vendor/datatables-plugins/dataTables.bootstrap.min.js\"></script>\n");
      out.write("    <script src=\"/resources/vendor/datatables-responsive/dataTables.responsive.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- Custom Theme JavaScript -->\n");
      out.write("    <script src=\"/resources/dist/js/sb-admin-2.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- Page-Level Demo Scripts - Tables - Use for reference -->\n");
      out.write("    <script>\n");
      out.write(" /*    $(document).ready(function() {\n");
      out.write("        $('#dataTables-example').DataTable({\n");
      out.write("            responsive: true\n");
      out.write("        });\n");
      out.write("    }); */\n");
      out.write("    </script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("\t$(document).ready(function(){\n");
      out.write("\n");
      out.write("\t\t$(\".list\").on(\"click\", function(){\n");
      out.write("\t\t\tself.location=\"/board/list\"\n");
      out.write("\t\t})\n");
      out.write("\t});\n");
      out.write("</script>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
