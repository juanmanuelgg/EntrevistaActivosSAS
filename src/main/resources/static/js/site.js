/*
Copyright 2021 Juan Manuel González Garzón

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
const urlTopic = 'api/topic';
const urlSubchapter = 'api/subchapter';

let subchapters = new Map()
let topics = [];

function getSubchapters() {
	fetch(urlSubchapter)
		.then(response => response.json())
		.then(data => _displaySubchapters(data))
		.catch(error => console.error('Unable to get subchapters.', error));
}

function getTopics() {
	fetch(urlTopic)
		.then(response => response.json())
		.then(data => _displayTopics(data))
		.catch(error => console.error('Unable to get topics.', error));
}

function addTopic() {
	const addSubchapterSelect = document.getElementById('add-subchapter');
	const addTextTextbox = document.getElementById('add-text');

	const item = {
		subchapter: addSubchapterSelect.value,
		text: addTextTextbox.value.trim()
	};

	fetch(urlTopic, {
		method: 'POST',
		headers: {
			'Accept': 'application/json',
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(item)
	})
		.then(response => response.json())
		.then(() => {
			getTopics();
			addTextTextbox.value = '';
		})
		.then(() => alertify.success('Topic added successfully!'))
		.catch(error => {
			alertify.notify('Unable to add topic.');
			//console.error('Unable to add topic.', error);
		});
		
}

function deleteTopic(id) {
	console.log('id', id)
	fetch(`${urlTopic}/${id}`, {
		method: 'DELETE'
	})
		.then(() => getTopics())
		.then(() => alertify.success('Topic deleted successfully!'))
		.catch(error => {
			alertify.notify('Unable to delete topic.');
			//console.error('Unable to delete topic.', error);
		});
}

function displayEditForm(id) {
	const item = topics.find(item => item.id === id);

	document.getElementById('edit-id').value = item.id;
	const sBody = document.getElementById('add-subchapter');
	document.getElementById('edit-subchapter').innerHTML = sBody.innerHTML;
	document.getElementById('edit-subchapter').value = item.subchapter;
	document.getElementById('edit-text').value = item.text;
	document.getElementById('editForm').style.display = 'block';
}

function updateTopic() {
	const itemId = document.getElementById('edit-id').value;
	const itemSubchapter = document.getElementById('edit-subchapter').value;
	const item = {
		id: parseInt(itemId, 10),
		subchapter: parseInt(itemSubchapter, 10),
		text: document.getElementById('edit-text').value.trim()
	};

	fetch(`${urlTopic}/${itemId}`, {
		method: 'PUT',
		headers: {
			'Accept': 'application/json',
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(item)
	})
		.then(() => getTopics())
		.then(() => alertify.success('Topic updated successfully!'))
		.catch(error => {
			alertify.notify('Unable to update topic.');
			//console.error('Unable to update topic.', error);
		});

	closeInput();

	return false;
}

function closeInput() {
	document.getElementById('editForm').style.display = 'none';
}

function _displayCount(itemCount) {
	const name = (itemCount === 1) ? 'topic' : 'topics';

	document.getElementById('counter').innerText = `${itemCount} ${name}`;
}

function _displaySubchapters(data) {
	const sBody = document.getElementById('add-subchapter');
	sBody.innerHTML = '';
	subchapters.clear();

	data.forEach(item => {
		let option = document.createElement("option");
		option.text = item.text;
		option.value = item.id;
		sBody.add(option);

		subchapters.set(item.id, item)
	});
}

function _displayTopics(data) {
	const tBody = document.getElementById('topics');
	tBody.innerHTML = '';

	_displayCount(data.length);

	const button = document.createElement('button');

	data.forEach(item => {
		let tr = tBody.insertRow();

		let td1 = tr.insertCell(0);
		let subchapterNode = document.createTextNode(subchapters.get(item.subchapter).text);
		td1.appendChild(subchapterNode);

		let td2 = tr.insertCell(1);
		let textNode = document.createTextNode(item.text);
		td2.appendChild(textNode);

		let td3 = tr.insertCell(2);
		let editButton = button.cloneNode(false);
		editButton.innerText = 'Edit';
		editButton.setAttribute('onclick', `displayEditForm(${item.id})`);
		td3.appendChild(editButton);

		let td4 = tr.insertCell(3);
		let deleteButton = button.cloneNode(false);
		deleteButton.innerText = 'Delete';
		deleteButton.setAttribute('onclick', `deleteTopic(${item.id})`);
		td4.appendChild(deleteButton);
	});

	topics = data;
}