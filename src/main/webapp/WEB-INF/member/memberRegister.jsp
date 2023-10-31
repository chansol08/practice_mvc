<%--
  Created by IntelliJ IDEA.
  User: chans
  Date: 2023-10-31
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">

    <title>member Register</title>

    <!--  start bootstrap3 info  -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <!--  end bootstrap3 info  -->

    <script type="text/javascript">
        //등록 onclick
        function add() {
            document.form1.action="<c:url value='/memberInsert.do' />";
            document.form1.submit();
        }

        //취소 버튼 onclick
        function reset() {
            document.form1.reset();
        }

        //아이디 중복확인 onclick
        function doubleCheck() {
            if ($("#id").val() == '') {
                alert("아이디를 입력하세요.");
                $('#id').focus();
                return;
            }

            const id = $("#id").val();
            $.ajax({
                url : "<c:url value='/memberDoubleCheck.do' />",
                type : "POST",
                data : {"id" : id},
                success : dbCheck,
                error : function() {
                    alert("error");
                }
            });
        }

        //중복확인 ajax 콜백 함수
        function dbCheck(isDuplication) {
            if (isDuplication === 'true') {
                alert("중복된 아이디 입니다.");
                $("#id").focus();
            } else {
                alert("사용 가능한 아이디 입니다.");
                $("#id").focus();
            }
        }
    </script>
</head>
<body>
<div class="container"> <%-- container --%>
    <h2>회원 가입 화면</h2>
    <div class="panel panel-default"> <%-- panel --%>
        <div class="panel-heading"> <%-- panel-header --%>
            <h3>안녕하세요.</h3>
        </div>
        <%-- end panel-header --%>
        <div class="panel-body"> <%-- panel-body --%>
            <form id="form1" name="form1" class="form-horizontal" method="post"> <%-- form --%>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="id">아이디:</label>
                    <div class="col-sm-10">
                        <table> <%-- table --%>
                            <tr>
                                <td>
                                    <input type="text" class="form-control" id="id" name="id"
                                           placeholder="아이디를 입력하세요" />
                                </td>
                                <td>
                                    <input type="button" value="중복확인" class="btn btn-warning"
                                           onclick="doubleCheck()" />
                                </td>
                            </tr>
                        </table>
                        <%-- end table --%>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="password">Password:</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="password" name="password"
                               placeholder="비밀번호를 입력하세요" style="width: 30%" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="name">이름:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="name" name="name"
                               placeholder="이름을 입력하세요" style="width: 30%" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="age">나이:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="age" name="age"
                               placeholder="나이를 입력하세요" style="width: 30%" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="email">이메일:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="email" name="email"
                               placeholder="이메일을 입력하세요" style="width: 30%" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="phone">전화번호:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="phone" name="phone"
                               placeholder="전화번호를 입력하세요" style="width: 30%" />
                    </div>
                </div>
            </form>
            <%-- end form --%>
        </div>
        <%-- end panel-body --%>
        <div class="panel-footer" style="text-align: center;"> <%-- panel-footer --%>
            <input type="button" value="등록" class="btn btn-primary" onclick="add()" />
            <input type="button" value="취소" class="btn btn-warning" onclick="reset()" />
            <input type="button" value="리스트" class="btn btn-success" onclick="location.href='/memberList.do'" />
        </div>
        <%-- end panel-footer --%>
    </div>
    <%-- end panel --%>
</div>
<%-- end container --%>
</body>
</html>
