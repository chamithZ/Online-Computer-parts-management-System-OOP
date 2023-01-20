function validatePassword() {

    const password = document.getElementById('password');
    const confirmPassword = document.getElementById('confirmPassword');

    if (password.value !== confirmPassword.value) {
        confirmPassword.setCustomValidity('Passwords do not match');
    } else {
        confirmPassword.setCustomValidity('');
    }

}

document.getElementById('submit-btn').addEventListener('click', validatePassword);

function togglePassword() {

    const password = document.getElementById('password');
    const confirmPassword = document.getElementById('confirmPassword');

    if (password.type === 'password') {
        password.type = 'text';
        confirmPassword.type = 'text';
    } else {
        password.type = 'password';
        confirmPassword.type = 'password';
    }

}

document.getElementById('togglePassword').addEventListener('click', togglePassword);