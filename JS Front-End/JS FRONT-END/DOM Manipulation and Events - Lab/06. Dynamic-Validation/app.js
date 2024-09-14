function validate() {
    let emailInputElement = document.getElementById('email');
    const pattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/

    emailInputElement.addEventListener('change', (e) => {
        if(!pattern.test(e.currentTarget.value)) {
            return e.currentTarget.classList.add('error');
        }

        e.currentTarget.classList.remove('error');
    });
}
