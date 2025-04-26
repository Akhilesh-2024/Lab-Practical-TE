<?php
require_once 'connection.php';

if (!isset($_POST['username'], $_POST['password'], $_POST['email'])) {
	exit('Please complete the registration form!');
}
if (empty($_POST['username']) || empty($_POST['password']) || empty($_POST['email'])) {
	exit('Please complete the registration form');
}

if ($stmt = $con->prepare('INSERT INTO accounts (username, password, email) VALUES (?, ?, ?)')) {
	$stmt->bind_param('sss', $_POST['username'], $_POST['password'], $_POST['email']);
	$stmt->execute();
	echo 'You have successfully registered! You can now login!';
} else {
	echo 'Could not prepare statement!';
}