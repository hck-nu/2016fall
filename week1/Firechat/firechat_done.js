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
  messagesRef.push({
    text: messageText.val() || 'yo',
    time: firebase.database.ServerValue.TIMESTAMP
  }).then(function () {
    messageText.val('');
  });
});

// messagesRef.once('value').then(function (snapshot) {
//   var messages = snapshot.val();
//   for (var key in messages) {
//     showMessage(messages[key]);
//   }
// });

messagesRef.on('child_added', function (snapshot) {
    showMessage(snapshot.val());
});

function showMessage(msg) {
  messageList.append($('<li>' + msg.text + '</li>'));
}
