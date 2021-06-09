<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<style>
h1{text-align:center;}
.redRow{color:red;}
.blueRow{color:#364967;}

table {width: 100%; margin-top:10px;text-align:center; margin-bottom:10px; border-top: 1px solid #364967; border-collapse: collapse;}
tr, td {border-bottom: 1px solid #444444; text-align:center; padding: 10px;}
.title {border-bottom: 1px solid #444444; text-align:center; padding: 10px; background:#364967; color:white;}
.btnStyle, button{width: 100px;
              padding: .5em .5em;
              border: 1px solid #364967;
              background: #364967;
              color: white;    
              font-weight:bold;
   	}
.active { font-weight:bold; color:#364967;}
#pagination{text-align:center;}
a{text-decoration:none; color:#364967;font-size:20px;}
a:hover{font-weight:bold;}
.keyword{width: 200px;
  padding: .5em .5em;
  font-weight: 800;
  border: 1px solid #364967;
  background: white;
  color:black;        
}
#divHeader{margin-bottom:10px;}
select { width: 130px;
            padding: .5em .5em;
            border: 1px solid #364967;
            font-family: inherit;
            background: no-repeat 95% 50%;
            border-radius: 0px;
            }               
select::-ms-expand {display: none;}
</style>
<title>거래내역</title>

</head>
<body>
	<h1>거래내역</h1>
	<table id="tbl">
		<tr class="row">	
			<td class="title">계좌번호</td>
			<td>${vo.ano}</td>
			<td class="title">계좌주</td>
			<td>${vo.aname}</td>
			<td class="title">잔액</td>
			<td id="balance">
				<fmt:formatNumber pattern="#,###" value="${vo.balance}"/></td>
		</tr>
	</table>
	<div style="border-top: 1px solid #364967; border-bottom: 1px solid #364967; padding:10px">
		<span>이체정보 :</span>
		<select id="tradeNo">
			<c:forEach items="${list}" var="v">
				<option value="${v.ano}">${v.aname}(${v.ano})</option>
			</c:forEach>		
		</select>
		<input type="text" placeholder="이체금액" class="keyword" id="amount"/>
		<button id="btnTrade">이체</button>
		<button onClick="location.href='list'">목록</button>
	</div>
	<div id="total"> </div>
	<table id="tbl_trade"></table>
		<script id="temp" type="text/x-handlebars-template">
			<tr class="title">
				<td>계좌번호</td>
               	<td>계좌주</td>
               	<td>거래유형</td>
 				<td>입출금액</td>
 				<td>거래일자</td>
            </tr>
			{{#each list}}
				<tr class="{{display type}}">
					<td>{{tradeNo}}</td>
              	 	<td>{{aname}}</td>
               		<td>{{type}}</td>
 					<td>{{amount}}</td>
 					<td>{{tradeDate}}</td>
				</tr>
			{{/each}}
		</script>
		   <script>
      Handlebars.registerHelper("display", function(type){
      if(type=="입금"){
      return "redRow";
      }else{
      return "blueRow";
      }
      });
      </script>
      <div id="pagination"></div>
		
</body>

<script>

var ano="${vo.ano}";
var page=1;
getList();

function getList(){
	$.ajax({
		  type:"get",
	      url:"tradeList",
	      dataType:"json",
	      data:{"ano":ano,"page":page},
	      success:function(data){
	         var temp=Handlebars.compile($("#temp").html());
	         $("#tbl_trade").html(temp(data));
	         $("#total").html("거래건 수 : " + data.pm.totalCount);
	         var str="";
	         if(data.pm.prev){
	        	 str += "<a href='" + (data.pm.startPage-1) + "'>◀ </a>  " ;
	         }
	         for(var i=data.pm.startPage; i<=data.pm.endPage; i++){
	        	 if(page==i){
	                   str += "<a href='" + i + "' class='active'>" + i + "</a>  ";
	                }else{
	                  str += "<a href='" + i + "'>" + i + "</a>  "; 
	                }       	 
	         }
	         if(data.pm.next){
	        	 str += "<a href='" + (data.pm.endPage-1) + "'>▶</a>  " ;
	         }
	         $("#pagination").html(str);
	      }
	});
}

$("#pagination").on("click","a",function(e){
	e.preventDefault();
	page=$(this).attr("href");
	getList();
});

$("#btnTrade").on("click",function(){
    var tradeNo=$("#tradeNo").val();
    var balance=parseInt($("#balance").html());
    var amount=$("#amount").val();
    if(amount==""){
       alert("이체할 금액을 입력하세요!");
    }else if(amount>balance){
       alert("잔액이 부족합니다!");
    }else{
       if(!confirm(tradeNo+"에게"+amount+"원을 이체하실래요?"))return;
       $.ajax({
          type:"post",
          url:"trade",
          data:{"ano":ano,"tradeNo":tradeNo,"amount":amount},
          success:function(){
             alert("이체완료");
             $("#balance").html(balance-amount);
             getList();
          }
       });
    }
    
    
 });
</script>
</html>