
$('#myModal').on('shown.bs.modal', function () {
	//shown.bs.modal을 클릭하면 '#myInput에 포커싱을 둬라
  $('#myInput').focus()
})

$('#exampleModal').on('show.bs.modal', function (event) {
	
  var button = $(event.relatedTarget)
  var recipient = button.data('whatever') 
  modal.find('.modal-title').text('New message to ' + recipient)
  modal.find('.modal-body input').val(recipient)
})