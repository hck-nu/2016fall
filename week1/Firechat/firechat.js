var config = {
  apiKey: 'key here',
  databaseURL: 'https://<DB URL HERE>.firebaseio.com'
};
firebase.initializeApp(config);

var database = firebase.database();
var messagesRef = database.ref('messages/');

var messageText = $('#message');
var sendButton = $('#send');
var messageList = $('#message-list');

sendButton.click(function () {
  // Push your message and clear the message box
});

// Use the on child_added event to get children

function showMessage(msg) {
  messageList.append($('<li>' + msg.text + '</li>'));
}
