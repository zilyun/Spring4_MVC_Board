$(function() {
	$("#comment table").hide(); // 1
	let page = 1; // 더 보기에서 보여줄 페이지를 기억할 변수
	const count = parseInt($("#count").text());
	if (count != 0) { // 댓글 갯수가 0이 아니면
		getList(1);   // 첫 페이지의 댓글을 구해 옵니다. (한 페이지에 3개씩 가져옵니다.)
	} else { // 댓글이 없는 경우
		$("#message").text("등록된 댓글이 없습니다.")
	}
})