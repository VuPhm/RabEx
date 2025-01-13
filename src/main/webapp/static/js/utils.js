/**
 * Load dữ liệu từ đối tượng JSON vào form.
 * @param {Object} data - Đối tượng JSON chứa dữ liệu của form.
 * @param {HTMLFormElement} form - Form HTML cần đổ dữ liệu vào.
 */
function populateForm(data, form) {
    for (const key in data) {
        if (data.hasOwnProperty(key)) {
            const input = form.querySelector(`[name="${key}"]`);
            if (input) {
                input.value = data[key];
            }
        }
    }
}

/**
 * Lấy dữ liệu từ form và trả về dưới dạng đối tượng JSON.
 * @param {HTMLFormElement} form - Form HTML cần lấy dữ liệu.
 * @returns {Object} - Đối tượng JSON chứa dữ liệu từ form.
 */
function getFormData(form) {
    const formData = new FormData(form);
    const data = {};
    for (const [key, value] of formData.entries()) {
        data[key] = value;
    }
    return data;
}
