<%--
  Created by IntelliJ IDEA.
  User: chans
  Date: 2023-11-01
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>member content</title>

    <!--  start bootstrap3 info  -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <!--  end bootstrap3 info  -->

    <script type="text/javascript">
        //수정 버튼 onclick
        function update() {
            document.form1.action="<c:url value="/memberUpdate.do" />";
            document.form1.submit();
        }

        //취소 버튼 onclick
        function reset() {
            document.form1.reset();
        }

        //파일 다운 a tag
        function getFile(filename) {
            location.href="<c:url value="/fileGet.do" />?filename=" + filename;
        }
    </script>
</head>
<body>
<div class="container"> <%-- container --%>
    <h2>상세 정보</h2>
    <div class="panel panel-default"> <%-- panel --%>
        <div class="panel-heading"> <%-- panel-header --%>
            <c:if test="${sessionScope.userId != null && sessionScope.userId != '' && sessionScope.userId == member.id}">
                <label>
                    <img src="<c:out value="file_repository/${member.filename}" />"
                         width="60px" height="60px" />
                    ${sessionScope.userName}님 환영합니다.
                </label>
            </c:if>
            <c:if test="${sessionScope.userId == null || sessionScope.userId == ''}">
                <label>
                    안녕하세요.
                </label>
            </c:if>
        </div>
        <%-- end panel-header --%>
        <div class="panel-body"> <%-- panel-body --%>
            <form id="form1" name="form1" class="form-horizontal" method="post"> <%-- form --%>
                <input type="hidden" name="number" value="${member.number}" />
                <div class="form-group">
                    <label class="control-label col-sm-2">번호:</label>
                    <div class="col-sm-10">
                        <c:out value="${member.number}" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2">아이디:</label>
                    <div class="col-sm-10">
                        <c:out value="${member.id}" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2">비밀번호:</label>
                    <div class="col-sm-10">
                        <c:out value="${member.password}" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2">이름:</label>
                    <div class="col-sm-10">
                        <c:out value="${member.name}" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2">나이:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="age" name="age" value="${member.age}" style="width: 10%" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2">이메일:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="email" name="email" value="${member.email}" style="width: 30%" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2">전화번호:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="phone" name="phone" value="${member.phone}" style="width: 30%" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2">첨부파일:</label>
                    <div class="col-sm-10">
                        <input type="file" id="file" name="file" /> <br>
                        <c:if test="${member.filename != null && member.filename != ''}">
                            <a href="javascript:getFile('${member.filename}')">
                                <c:out value="${member.filename}" />
                            </a>
                            <c:if test="${sessionScope.userId != null && sessionScope.userId == member.id && member.filename != null && member.filename != ''}">
                                <sapn class="glyphicon glyphicon-remove"></sapn>
                            </c:if>
                        </c:if>
                    </div>
                </div>
            </form>
            <%-- end form --%>
        </div>
        <%-- end panel-body --%>
        <div class="panel-footer" style="text-align: center;"> <%-- panel-footer --%>
            <c:if test="${!empty sessionScope.userId}">
                <c:if test="${sessionScope.userId == member.id}">
                    <input type="button" value="수정하기" class="btn btn-primary"
                           onclick="update()" />
                    <input type="button" value="취소" class="btn btn-warning" onclick="reset()" />
                </c:if>
                <c:if test="${sessionScope.userId != member.id}">
                    <input type="button" value="수정하기" class="btn btn-primary"
                           onclick="update()" disabled="disabled" />
                    <input type="button" value="취소" class="btn btn-warning"
                           onclick="reset()" disabled="disabled" />
                </c:if>
            </c:if>
            <input type="button" value="리스트" onclick="location.href='/memberList.do'" class="btn btn-success" />
        </div>
        <%-- end panel-footer --%>
    </div>
    <%-- end panel --%>
</div>
<%-- end container --%>
</body>
</html>