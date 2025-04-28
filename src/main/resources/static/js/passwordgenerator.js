function generatePassword() {
    const length = document.getElementById('length').value;
    const specialChars = '!"§$%&/()=,;.';
    let selectedSpecialChars = '';

    for (let i = 1; i <= specialChars.length; i++) {
        if (document.getElementById('specialChar' + i).checked) {
            selectedSpecialChars += specialChars[i - 1];
        }
    }

    const includeNumbers = document.getElementById('numbers').checked;
    const includeUppercase = document.getElementById('uppercase').checked;
    const includeLowercase = document.getElementById('lowercase').checked;

    let charset = '';
    if (includeNumbers) charset += '0123456789';
    if (includeUppercase) charset += 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
    if (includeLowercase) charset += 'abcdefghijklmnopqrstuvwxyz';
    charset += selectedSpecialChars;

    let password = '';
    for (let i = 0; i < length; i++) {
        const randomIndex = Math.floor(Math.random() * charset.length);
        password += charset[randomIndex];
    }

    document.getElementById('generatedPassword').innerText = password;
}
