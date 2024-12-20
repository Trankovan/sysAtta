document.addEventListener('DOMContentLoaded', () => {
    const requestForm = document.getElementById('requestForm');
    const successMessage = document.getElementById('successMessage');
    const errorMessage = document.getElementById('errorMessage');

    requestForm.addEventListener('submit', async (event) => {
        event.preventDefault(); // Prevent the default form submission

        const title = document.getElementById('title').value.trim();
        const content = document.getElementById('content').value.trim();

        try {
            const response = await fetch('/create-request', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded',
                },
                body: `title=${encodeURIComponent(title)}&content=${encodeURIComponent(content)}`,
            });

            if (response.ok) {
                successMessage.textContent = 'Request created successfully';
                errorMessage.textContent = '';
                requestForm.reset(); // Clear the form fields
            } else {
                const errorText = await response.text();
                errorMessage.textContent = `Failed to create request: ${errorText}`;
                successMessage.textContent = '';
            }
        } catch (error) {
            console.error('Error creating request:', error);
            errorMessage.textContent = 'An error occurred. Please try again.';
            successMessage.textContent = '';
        }
    });
});
