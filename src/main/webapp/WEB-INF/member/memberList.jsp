<%--
  Created by IntelliJ IDEA.
  User: chans
  Date: 2023-10-30
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>member list</title>

    <!--  start bootstrap3 info  -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <!--  end bootstrap3 info  -->

    <script type="text/javascript">
        /*
        * 정보가 없거나 잘못된 아이디와 비밀번호로 로그인 시 session에 저장된 메시지 출력
        * 후에 JSTL 문법 remove 통해 session에서 제거
         */
        $(document).ready(function () {
            <c:if test="${!empty message}">
                alert("${message}");
                <c:remove var="messge" scope="session" />
            </c:if>
        });

        //삭제할 회원의 고유 값을(기본키) querystring 으로 넘기기 위한 함수
        function deleteFn(number) {
            location.href = 'memberDelete.do?number=' + number;
        }

        //간단한 유효성 검사
        function check() {
            if ($('#user_id').val() == '') {
                alert('아이디를 입력하세요');
                return false;
            }

            if ($('#password').val() == '') {
                alert('아이디를 입력하세요');
                return false;
            }

            return true;
        }

        //로그아웃 함수
        function logout() {
            location.href="<c:url value='/memberLogout.do' />";
        }
    </script>
</head>
<body>
<div class="container"> <%-- container --%>
    <h2>회원 관리 시스템</h2>
    <div class="panel panel-default"> <%-- panel --%>
        <div class="panel-heading"> <%-- panel-header --%>
            <c:if test="${sessionScope.userId == null || sessionScope.userId == ''}">
                <form class="form-inline" action="/memberLogin.do" method="post">
                    <div class="form-group">
                        <label for="user_id">ID:</label>
                        <input type="text" class="form-control" id="user_id" name="user_id">
                    </div>
                    <div class="form-group">
                        <label for="password">Password:</label>
                        <input type="password" class="form-control" id="password" name="password">
                    </div>
                    <button type="submit" class="btn btn-default" onclick="return check()">로그인</button>
                </form>
            </c:if>
            <c:if test="${sessionScope.userId != null && sessionScope.userId != ''}">
                ${sessionScope.userName}님 환영합니다.
                <button type="button" class="btn btn-warning" onclick="logout()">로그아웃</button>
            </c:if>
        </div>
        <%-- end panel-header --%>
        <div class="panel-body"> <%-- panel-body --%>
            <div class="table-responsive"> <%-- table wrapper --%>
                <table class="table table-hover"> <%-- table --%>
                    <thead>
                    <tr>
                        <th>번호</th>
                        <th>아이디</th>
                        <th>비밀번호</th>
                        <th>이름</th>
                        <th>나이</th>
                        <th>이메일</th>
                        <th>전화번호</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="member" items="${members}">
                        <tr>
                            <td>
                                    ${member.number}
                            </td>
                            <td>
                                <a href="/memberContent.do?number=${member.number}"/>${member.id}
                            </td>
                            <td>
                                    ${member.password}
                            </td>
                            <td>
                                    ${member.name}
                            </td>
                            <td>
                                    ${member.age}
                            </td>
                            <td>
                                    ${member.email}
                            </td>
                            <td>
                                    ${member.phone}
                            </td>
                            <c:if test="${sessionScope.userId == member.id}">
                                <td>
                                    <input type="button" value="삭제" class="btn btn-warning"
                                           onclick="deleteFn(${member.number})" />
                                </td>
                            </c:if>
                            <c:if test="${sessionScope.userId != member.id}">
                                <td>
                                    <input type="button" value="삭제" class="btn btn-warning"
                                           onclick="deleteFn(${member.number})" disabled="disabled" />
                                </td>
                            </c:if>
                        </tr>
                    </c:forEach>
                    <c:if test="${sessionScope.userId == null || sessionScope.uerId == ''}">
                        <tr>
                            <td colspan="8" align="left">
                                <input type="button" value="회원가입" class="btn btn-primary"
                                       onclick="location.href='/memberRegister.do'"/>
                            </td>
                        </tr>
                    </c:if>
                    </tbody>
                </table>
                <%-- end table --%>
            </div>
            <%-- end table wrapper --%>
        </div>
        <%-- end panel-body --%>
        <div class="panel-footer"> <%-- panel-footer --%>
            회원 관리 ERP System
        </div>
        <%-- end panel-footer --%>
    </div>
    <%-- end panel --%>
</div>
<%-- end container --%>
</div>
</body>
</html>
