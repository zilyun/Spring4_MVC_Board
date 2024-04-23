$(function() {
	$("#comment table").hide(); // 1
	let page = 1; // 더 보기에서 보여줄 페이지를 기억할 변수
	const count = parseInt($("#count").text());
	if (count != 0) { // 댓글 갯수가 0이 아니면
		getList(1);   // 첫 페이지의 댓글을 구해 옵니다. (한 페이지에 3개씩 가져옵니다.)
	} else { // 댓글이 없는 경우
		$("#message").text("등록된 댓글이 없습니다.")
	}
	
	function getList(currentPage) {
		$.ajax({
			type : "post",
			url : "../comment/list",
			data : {
				"board_num" : $("#board_num").val(),
				"page" : currentPage
			},
			dataType : "json",
			success : function(rdata) {
				$("#count").text(rdata.listcount);
				if (rdata.listcount > 0) {
					$("#comment table").show(); // 문서가 로딩될 때 hide() 했던 부분을 보이게 합니다. (1)
					$("#comment tbody").empty();
					$(rdata.list).each(function() {
						let output = '';
						let img = '';
						if($("#loginid").val() == this.id) {
							img = "<img src='../image/pencil.png' width='15px' class='update'>"
								+ "<img src='../image/delete.png' width='15px' class='remove'>"
								+ "<input type='hidden' value='" + this.num + "'>";
						}
						output += "<tr><td>" + this.id + "</td>";
						
						// XSS(Cross-Site Scripting): 권한이 없는 사용자가 웹 사이트에 스크립트를 삽입하는 공격 기법
						// 이것을 방지하기 위한 방법으로 2번처럼 <td></td> 영역을 만든 뒤 3번 에서 text() 안에 
						// this.content를 넣어 스크립트를 문자열로 만듭니다.
						output += "<td></td>"; //2 
						
						// 2번과 3번을 이용하지 않고 4번을 이용하면 내용에 스크립트가 있는 경우 스크립트가 실행됩니다.
						// output += "<td>" + this.content + "</td>": //4
						output += "<td>" + this.reg_date + img + "</td></tr>";
						$("#comment tbody").append(output);
						
						// append한 마지막 tr의 2번째 자식 td를 찾아 text() 메서드로 content를 넣습니다.
						$("#comment tbody tr:last").find("td:nth-child(2)").text(this.content); //3
					
					}); // each end
				}
			}
		})
	}

	// 글자 수 50개 제한하는 이벤트
	$("#content").on('keyup', function() {
		let content = $(this).val();
		const length =content.length;
		if (length > 50) {
			length = 50;
			content = content.substring(0, length);
		}
		$(".float-left").text(length + "/50")
	})
	
	// 등록 또는 수정완료 버튼을 클릭한 경우
	// 버튼의 라벨이 '등록'인 경우는 댓글을 추가하는 경우
	// 버튼의 라벨이 '수정완료'인경우는 댓글을 수정하는 경우
	$("#write").click(function() {
		const content = $("#content").val().trim();
		if(!content){
			alert('내용을 입력하세요')
			return false
		}
		const buttonText = $("#write").text(); // 버튼의 라벨로 add할지 update할지 결정
		
		$(".float-left").text('총 50자까지 가능합니다.');
		
		if (buttonText == "등록") { // 댓글을 추가하는 경우
			url = "../comment/add";
			data = {
				"content" : content,
				"id" : $("#loginid").val(),
				"board_num" : $("#board_num").val()
			};	
		} else { // 댓글을 수정하는 경우 
			url = "../comment/update";
			data = {
				"num" : num,
				"content" : content
			};
			$("#write").text("등록"); // 다시 등록으로 변경
			$("#comment .cancel").remove(); // 취소 버튼 삭제	
		}
		
		$.ajax({
			type : "post",
			url : url,
			data : data,
			success : function(result) {
				$("#content").val('');
				if (result == 1) {
					//page=1
					getList(page); // 등록, 수정완료 후 해당 페이지 보여줍니다.
				} //if
			}//success
		})//ajax end
	})// $("#wirte") end
	
})

