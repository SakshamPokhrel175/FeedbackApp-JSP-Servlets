console.log("File loaded");


document.getElementById('feedbackForm').addEventListener('keypress', function(event) {
    if (event.key === 'Enter') {
        this.submit(); // Submit the form directly
    }
});
