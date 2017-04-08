function changeFormActionAndSubmit(formId,action,method) {
	$("#"+formId).attr('action',action);
	$("#"+formId).attr('method',method);
	$("#"+formId).submit();
}