var rootURL = "http://localhost:8080/tasks";
  
function findAll(callback) {
 $.ajax({
  type : 'GET',
  url : rootURL,
  dataType : "json", 
  success : callback
 });
}
  
function findByName(name, callback) {
  
 if (name != null && name != "") {
  $.ajax({
   type : 'GET',
   url : rootURL + '/find/' + name,
   dataType : "json",
   success : callback
  });
 } else {
  findAll(callback);
 }
}
  
function findById(id, callback) {
 $.ajax({
  type : 'GET',
  url : rootURL + '/' + id,
  dataType : "json",
  success : callback
 });
}
  
function addTask(task, callback) {
 $.ajax({
  type : 'POST',
  contentType : 'application/json',
  url : rootURL,
  dataType : "json",
  data : contact,
  success : callback,
  error : function(jqXHR, textStatus, errorThrown) {
   alert('Erro criando uma task: ' + jqXHR.responseText);
  }
 });
}
  
function updateTask(id, task, callback) {
 $.ajax({
  type : 'PUT',
  contentType : 'application/json',
  url : rootURL + '/' + id,
  data : contact,
  success : callback,
  error : function(jqXHR, textStatus, errorThrown) {
   alert('Erro atualizando contato: ' + textStatus);
  }
 });
}
  
function deleteTask(id, callback) {
 $.ajax({
  type : 'DELETE',
  url : rootURL + '?taskId=' + id,
  success : callback,
  error : function(jqXHR, textStatus, errorThrown) {
   alert('Erro excluindo task: ' + textStatus);
  }
 });
}