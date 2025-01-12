/**
 * Gán giá trị vào các input dựa trên danh sách id và object
 * @param {Object} obj - Object chứa các giá trị để gán
 * @param {string[]} names - Danh sách id của các input
 */
function setInputValues(obj, names) {
    names.forEach(name => {
        const inputs = document.getElementsByName(name); // Tìm tất cả các input theo name

        Array.from(inputs).forEach(input => {
            if (input) {
                if (input.type === "checkbox") {
                    // Nếu là checkbox, gán thuộc tính 'checked' theo giá trị boolean
                    input.checked = obj.hasOwnProperty(name) ? obj[name] : false;
                } else {
                    // Nếu không phải checkbox, gán giá trị vào 'value'
                    if (obj.hasOwnProperty(name)) {
                        input.value = obj[name];
                    }
                }
            }
        });
    });
}
