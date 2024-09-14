function encodeAndDecodeMessages() {
   let [encodeBtnElement, decodeBtnElement] = document.querySelectorAll('div button');
   let [encodeTextareaElement, decodeTextareaElement] = document.querySelectorAll('div textarea'); 

   function encodeOrDecodeMessage(text, asciiDiff) {
    return text.split('')
               .map((char) => {
                     let currentAscii = char.charCodeAt(0);
                     return String.fromCharCode(currentAscii + asciiDiff);
               })
               .join('');
   }

   function encodeMessageHandler() {
    decodeTextareaElement.value = encodeOrDecodeMessage(encodeTextareaElement.value, 1);
    encodeTextareaElement.value = '';
   }

   function decodeMessageHandler() {
    encodeTextareaElement.value = encodeOrDecodeMessage(decodeTextareaElement.value, -1);
   }

   encodeBtnElement.addEventListener('click', encodeMessageHandler);
   decodeBtnElement.addEventListener('click', decodeMessageHandler);
}


