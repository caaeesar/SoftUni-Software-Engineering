function focused() {
    let inputElements = document.querySelectorAll('input[type=text]');

    inputElements.forEach(e => e.addEventListener('focus', (e) => {
        e.currentTarget.parentElement.classList.add('focused');
    }));

    inputElements.forEach(e => e.addEventListener('blur', (e) => {
        e.currentTarget.parentElement.classList.remove('focused');
    }))
}
