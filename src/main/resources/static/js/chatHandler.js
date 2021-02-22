'use strict';

var messageForm = document.querySelector('#messageForm');
var messageInput = document.querySelector('#message');
var messageArea = document.querySelector('#style-3');
var username = document.querySelector('#modal-username').textContent;
var stompClient = null;


function connect(){

    if (username){
        var socket = new SockJS('/ws');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, onConnected, onError);
    }
}
function onConnected(){
    stompClient.subscribe('/topic/public', onMessageReceived);
    console.log("get connection")
}

function onError(error){
    console.log("can not get connection");
}
function sendMessage(event){
    var messageContent = messageInput.value.trim();
    if (messageContent){
        var chatMessage = {
            sender: username,
            content: messageInput.value,
            type:'CHAT'
        };
        stompClient.send("/app/chat.sendMessage",{},JSON.stringify(chatMessage))
        messageInput.value = '';
    }
    event.preventDefault();
}

function onMessageReceived(payload){
    var message = JSON.parse(payload.body);
    var messageElement = document.createElement('li');
    if (message.type === 'CHAT'){
        messageElement.classList.add('chat-message');
        var usernameElement = document.createElement('span');
        var usernameText = document.createTextNode(message.sender + " 说:");
        usernameElement.appendChild(usernameText);
        messageElement.appendChild(usernameElement);
    }
    var textElement = document.createElement('p');
    var messageText = document.createTextNode(message.content);
    textElement.appendChild(messageText);
    messageElement.appendChild(textElement);
    messageArea.appendChild(messageElement);
    messageArea.scrollTop = messageArea.scrollHeight;

}
connect();
messageForm.addEventListener('submit', sendMessage, true);