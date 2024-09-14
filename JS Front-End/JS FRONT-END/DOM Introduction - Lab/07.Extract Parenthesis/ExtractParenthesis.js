function extract(content) {
    let contentElement = document.getElementById('content');

    const pattern = /\(([^()]+)\)/g;

    const matches = contentElement.textContent.matchAll(pattern);
    let result = Array.from(matches).map(match => match[1]).join(';');
    
    return result;
}
