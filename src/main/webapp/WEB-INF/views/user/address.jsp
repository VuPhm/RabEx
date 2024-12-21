<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../common/taglib.jsp" %>
<html>
<head>
    <%@include file="/WEB-INF/views/common/user/head-link.jsp" %>
    <title>Địa chỉ</title>
    <style>
        .address-item {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 15px;
            border-bottom: 1px solid #e0e0e0;
        }

        .address-details {
            flex-grow: 1;
        }

        .address-actions {
            display: flex;
            gap: 10px;
        }

        .address-table {
            width: 100%;
            border-collapse: collapse;
        }

        .address-table th, .address-table td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        .address-table th {
            background-color: #f2f2f2;
            font-weight: bold;
        }
    </style>
</head>
<body>
<%-- Nav --%>
<%@include file="../common/user/navbar.jsp" %>
<%-- End Nav --%>

<%--Heading--%>
<section class="text-center text-md-start">
    <!-- Background gradient -->
    <div style="height: 60px;">
    </div>
    <!-- Background gradient -->
</section>
<%--Heading--%>

<%--content--%>
<main id="content">
    <div class="container p-4">
        <section class="mb-4">
            <div class="card">
                <div class="card-header bg-white">
                    <h5 style="font-size: 24px;">Quản lý địa chỉ</h5>
                </div>
                <div class="card-body">
                    <%--Form thêm địa chỉ--%>
                    <form id="add-address-form">
                        <a class="btn btn-outline-primary" href="#" data-mdb-ripple-init data-mdb-modal-init
                           data-mdb-target="#address-edit">
                            <i class="fas fa-edit me-2"></i>Thêm địa chỉ mới
                        </a>
                    </form>
                    <%--Address Edit Modal--%>
                    <div class="modal fade" id="address-edit" tabindex="-1" aria-labelledby="address-edit"
                         aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <!-- Modal Header -->
                                <div class="modal-header">
                                    <h5 class="modal-title">Thêm địa chỉ mới</h5>
                                    <button type="button" class="btn-close" data-mdb-dismiss="modal"
                                            aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <form id="address-form">
                                        <input type="hidden" id="address-index">

                                        <div class="row mb-3">
                                            <div class="col-md-4">
                                                <label class="form-label">Tên</label>
                                                <input type="text" class="form-control" id="name" required>
                                            </div>
                                            <div class="col-md-4">
                                                <label class="form-label">Số điện thoại</label>
                                                <input type="tel" class="form-control" id="phone" required>
                                            </div>
                                            <div class="col-md-4">
                                                <label class="form-label">Loại địa chỉ</label>
                                                <select id="address-type" class="form-select">
                                                    <option value="home">Nhà riêng</option>
                                                    <option value="work">Văn phòng</option>
                                                    <option value="other">Khác</option>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="row mb-3">
                                            <div class="col-md-4">
                                                <label class="form-label">Tỉnh/Thành phố</label>
                                                <select id="province" class="form-select" required>
                                                    <option value="">Chọn tỉnh/thành phố</option>
                                                    <option value="1">Hà Nội</option>
                                                    <option value="2">Hồ Chí Minh</option>
                                                    <option value="3">Đà Nẵng</option>
                                                </select>
                                            </div>
                                            <div class="col-md-4">
                                                <label class="form-label">Quận/Huyện</label>
                                                <select id="district" class="form-select" required>
                                                    <option value="">Chọn quận/huyện</option>
                                                </select>
                                            </div>
                                            <div class="col-md-4">
                                                <label class="form-label">Phường/Xã</label>
                                                <input type="text" class="form-control" id="ward" required>
                                            </div>
                                        </div>

                                        <div class="mb-3">
                                            <label class="form-label">Địa chỉ chi tiết</label>
                                            <input type="text" class="form-control" id="address" required>
                                        </div>

                                        <div class="mb-3">
                                            <label class="form-label">Ghi chú giao hàng</label>
                                            <textarea class="form-control" id="delivery-instructions"
                                                      rows="3"></textarea>
                                        </div>

                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox" id="default-address">
                                            <label class="form-check-label" for="default-address">
                                                Đặt làm địa chỉ mặc định
                                            </label>
                                        </div>
                                    </form>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-mdb-dismiss="modal">Đóng
                                    </button>
                                    <button type="button" class="btn btn-primary" id="save-address">Lưu địa chỉ</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <hr/>
                    <!-- Address List Table -->
                    <div class="table-responsive">
                        <table class="table table-hover visible" id="address-table">
                            <thead>
                            <tr>
                                <th>STT</th>
                                <th>Tên</th>
                                <th>Số điện thoại</th>
                                <th>Địa chỉ</th>
                                <th>Loại địa chỉ</th>
                                <th>Mặc định</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody id="address-container">
                            <!-- Addresses will be dynamically added here -->
                            <tr class="active">
                                <td>1</td>
                                <td>Ngô Văn</td>
                                <td>0385874145</td>
                                <td>214B Đ.Tam Bình, Khu phố 2, Tam Phú, Thủ Đức, Hồ Chí Minh</td>
                                <td>Nhà riêng</td>
                                <td>
                                    <span class="badge rounded-pill bg-success">Mặc định</span>
                                </td>
                                <td>
                                    <a class="btn btn-sm btn-outline-primary edit-address" data-index="0">
                                        <i class="fas fa-edit me-1"></i>
                                    </a>
                                    <a class="btn btn-sm btn-outline-danger remove-address" data-index="0">
                                        <i class="fas fa-trash me-1"></i>
                                    </a>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </section>
    </div>
</main>
<%--content--%>
<%--<%@include file="../common/user/script.jsp" %>--%>
<%--<script src="<c:url value="/static/js/quill.js"/>"></script>--%>
<%--<script>--%>
<%--    const sidenav = document.getElementById("main-sidenav");--%>

<%--    const sidenavInstance = mdb.Sidenav.getInstance(sidenav);--%>

<%--    const currencyFormat = Intl.NumberFormat("vi-VN", {style: 'currency', currency: 'VND'})--%>


<%--    let innerWidth = null;--%>

<%--    //--%>

<%--    const setMode = (e) => {--%>
<%--        // Check necessary for Android devices--%>
<%--        if (window.innerWidth === innerWidth) {--%>
<%--            return;--%>
<%--        }--%>

<%--        innerWidth = window.innerWidth;--%>

<%--        if (window.innerWidth < 1400) {--%>
<%--            sidenavInstance.changeMode("over");--%>
<%--            sidenavInstance.hide();--%>
<%--        } else {--%>
<%--            sidenavInstance.changeMode("side");--%>
<%--            sidenavInstance.show();--%>
<%--        }--%>
<%--    };--%>

<%--    setMode();--%>

<%--    // Event listeners--%>
<%--    window.addEventListener("resize", setMode);--%>

<%--    const searchFocus = document.getElementById('search-focus');--%>
<%--    const keys = [--%>
<%--        {keyCode: 'AltLeft', isTriggered: false},--%>
<%--        {keyCode: 'ControlLeft', isTriggered: false},--%>
<%--    ];--%>

<%--    window.addEventListener('keydown', (e) => {--%>
<%--        keys.forEach((obj) => {--%>
<%--            if (obj.keyCode === e.code) {--%>
<%--                obj.isTriggered = true;--%>
<%--            }--%>
<%--        });--%>

<%--        const shortcutTriggered = keys.filter((obj) => obj.isTriggered).length === keys.length;--%>

<%--        if (shortcutTriggered) {--%>
<%--            searchFocus.focus();--%>
<%--        }--%>
<%--    });--%>

<%--    window.addEventListener('keyup', (e) => {--%>
<%--        keys.forEach((obj) => {--%>
<%--            if (obj.keyCode === e.code) {--%>
<%--                obj.isTriggered = false;--%>
<%--            }--%>
<%--        });--%>
<%--    });--%>

<%--    // Address Management Script--%>

<%--    const addressContainer = document.getElementById("address-container");--%>
<%--    const addressForm = document.getElementById("address-form");--%>
<%--    const saveAddressBtn = document.getElementById("save-address");--%>
<%--    const provinceSelect = document.getElementById("province");--%>
<%--    const districtSelect = document.getElementById("district");--%>
<%--    const addressEditModal = new mdb.Modal(document.getElementById("address-edit"));--%>
<%--    let currentEditIndex = null;--%>

<%--    // Save addresses to localStorage--%>
<%--    function saveAddresses(addresses) {--%>
<%--        localStorage.setItem('addresses', JSON.stringify(addresses));--%>
<%--    }--%>

<%--    // Get addresses from localStorage--%>
<%--    function getAddresses() {--%>
<%--        const addresses = localStorage.getItem('addresses');--%>
<%--        return addresses ? JSON.parse(addresses) : [];--%>
<%--    }--%>

<%--    // Render addresses in the table--%>
<%--    function renderAddresses() {--%>
<%--        const addresses = getAddresses();--%>
<%--        addressContainer.innerHTML = '';--%>

<%--        addresses.forEach((addr, index) => {--%>
<%--            const addressRow = document.createElement('tr');--%>

<%--            addressRow.innerHTML = `--%>
<%--            <td>${index + 1}</td>--%>
<%--            <td>${addr.name}</td>--%>
<%--            <td>${addr.phone}</td>--%>
<%--            <td>${addr.address}, ${addr.ward}, ${addr.district}, ${addr.province}</td>--%>
<%--            <td>${getAddressTypeLabel(addr.type)}</td>--%>
<%--            <td>--%>
<%--                ${addr.isDefault--%>
<%--                ? '<span class="badge bg-success">Mặc định</span>'--%>
<%--                : '<span class="badge bg-secondary">-</span>'}--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                <a class="btn btn-sm btn-outline-primary edit-address" data-index="${index}">--%>
<%--                    <i class="fas fa-edit me-1"></i>--%>
<%--                </a>--%>
<%--                <a class="btn btn-sm btn-outline-danger remove-address" data-index="${index}">--%>
<%--                    <i class="fas fa-trash me-1"></i>--%>
<%--                </a>--%>
<%--            </td>--%>
<%--        `;--%>

<%--            addressContainer.appendChild(addressRow);--%>
<%--        });--%>

<%--        // Add event listeners for edit and remove buttons--%>
<%--        addAddressActionListeners();--%>
<%--    }--%>

<%--    // Get address type label--%>
<%--    function getAddressTypeLabel(type) {--%>
<%--        const addressTypes = {--%>
<%--            'home': 'Nhà riêng',--%>
<%--            'work': 'Văn phòng',--%>
<%--            'other': 'Khác'--%>
<%--        };--%>
<%--        return addressTypes[type] || type;--%>
<%--    }--%>

<%--    // Update district options based on province--%>
<%--    function updateDistrictOptions(provinceId) {--%>
<%--        const districtOptions = {--%>
<%--            '1': [--%>
<%--                {value: '1', label: 'Hoàn Kiếm'},--%>
<%--                {value: '2', label: 'Đống Đa'},--%>
<%--                {value: '3', label: 'Ba Đình'}--%>
<%--            ],--%>
<%--            '2': [--%>
<%--                {value: '1', label: 'Quận 1'},--%>
<%--                {value: '2', label: 'Quận 3'},--%>
<%--                {value: '3', label: 'Thủ Đức'}--%>
<%--            ],--%>
<%--            '3': [--%>
<%--                {value: '1', label: 'Hải Châu'},--%>
<%--                {value: '2', label: 'Thanh Khê'},--%>
<%--                {value: '3', label: 'Sơn Trà'}--%>
<%--            ]--%>
<%--        };--%>

<%--        districtSelect.innerHTML = '<option value="">Chọn quận/huyện</option>';--%>

<%--        if (districtOptions[provinceId]) {--%>
<%--            districtOptions[provinceId].forEach(option => {--%>
<%--                const optionElement = document.createElement('option');--%>
<%--                optionElement.value = option.value;--%>
<%--                optionElement.textContent = option.label;--%>
<%--                districtSelect.appendChild(optionElement);--%>
<%--            });--%>
<%--        }--%>
<%--    }--%>

<%--    // Add event listeners for edit and remove buttons--%>
<%--    function addAddressActionListeners() {--%>
<%--        // Remove address--%>
<%--        addressContainer.querySelectorAll('.remove-address').forEach(btn => {--%>
<%--            btn.addEventListener('click', function() {--%>
<%--                const index = this.getAttribute('data-index');--%>
<%--                const addresses = getAddresses();--%>

<%--                // Confirm before deletion--%>
<%--                if (confirm('Bạn có chắc chắn muốn xóa địa chỉ này?')) {--%>
<%--                    addresses.splice(index, 1);--%>
<%--                    saveAddresses(addresses);--%>
<%--                    renderAddresses();--%>
<%--                }--%>
<%--            });--%>
<%--        });--%>

<%--        // Edit address--%>
<%--        addressContainer.querySelectorAll('.edit-address').forEach(btn => {--%>
<%--            btn.addEventListener('click', function() {--%>
<%--                const index = this.getAttribute('data-index');--%>
<%--                const addresses = getAddresses();--%>
<%--                const addressToEdit = addresses[index];--%>

<%--                // Reset form--%>
<%--                addressForm.reset();--%>

<%--                // Populate form with existing address data--%>
<%--                document.getElementById('name').value = addressToEdit.name;--%>
<%--                document.getElementById('phone').value = addressToEdit.phone;--%>
<%--                document.getElementById('province').value =--%>
<%--                    Array.from(provinceSelect.options).find(option =>--%>
<%--                        option.text === addressToEdit.province--%>
<%--                    )?.value || '';--%>

<%--                // Update district options based on province--%>
<%--                updateDistrictOptions(addressToEdit.province);--%>

<%--                // Set district after a short delay to ensure options are populated--%>
<%--                setTimeout(() => {--%>
<%--                    document.getElementById('district').value =--%>
<%--                        Array.from(districtSelect.options).find(option =>--%>
<%--                            option.text === addressToEdit.district--%>
<%--                        )?.value || '';--%>
<%--                }, 100);--%>

<%--                document.getElementById('ward').value = addressToEdit.ward;--%>
<%--                document.getElementById('address').value = addressToEdit.address;--%>
<%--                document.getElementById('delivery-instructions').value = addressToEdit.deliveryInstructions || '';--%>
<%--                document.getElementById('address-type').value = addressToEdit.type;--%>
<%--                document.getElementById('default-address').checked = addressToEdit.isDefault;--%>

<%--                // Store the index of the address being edited--%>
<%--                currentEditIndex = index;--%>

<%--                // Show the modal--%>
<%--                addressEditModal.show();--%>
<%--            });--%>
<%--        });--%>
<%--    }--%>

<%--    // Province change event listener--%>
<%--    provinceSelect.addEventListener('change', function() {--%>
<%--        updateDistrictOptions(this.value);--%>
<%--    });--%>

<%--    // Save address event listener--%>
<%--    saveAddressBtn.addEventListener('click', function() {--%>
<%--        const name = document.getElementById('name').value;--%>
<%--        const phone = document.getElementById('phone').value;--%>
<%--        const provinceElement = document.getElementById('province');--%>
<%--        const districtElement = document.getElementById('district');--%>
<%--        const ward = document.getElementById('ward').value;--%>
<%--        const address = document.getElementById('address').value;--%>
<%--        const deliveryInstructions = document.getElementById('delivery-instructions').value;--%>
<%--        const type = document.getElementById('address-type').value;--%>
<%--        const isDefault = document.getElementById('default-address').checked;--%>

<%--        // Validate form--%>
<%--        const form = document.getElementById('address-form');--%>
<%--        if (!form.checkValidity()) {--%>
<%--            form.reportValidity();--%>
<%--            return;--%>
<%--        }--%>

<%--        // Get current addresses--%>
<%--        const addresses = getAddresses();--%>

<%--        // If new address is set as default, remove default from others--%>
<%--        if (isDefault) {--%>
<%--            addresses.forEach(addr => addr.isDefault = false);--%>
<%--        }--%>

<%--        const newAddress = {--%>
<%--            name,--%>
<%--            phone,--%>
<%--            province: provinceElement.options[provinceElement.selectedIndex].text,--%>
<%--            district: districtElement.options[districtElement.selectedIndex].text,--%>
<%--            ward,--%>
<%--            address,--%>
<%--            deliveryInstructions,--%>
<%--            type,--%>
<%--            isDefault--%>
<%--        };--%>

<%--        // If editing existing address, replace it--%>
<%--        if (currentEditIndex !== null) {--%>
<%--            addresses[currentEditIndex] = newAddress;--%>
<%--            currentEditIndex = null;--%>
<%--        } else {--%>
<%--            // Otherwise, add new address--%>
<%--            addresses.push(newAddress);--%>
<%--        }--%>

<%--        // Save and render--%>
<%--        saveAddresses(addresses);--%>
<%--        renderAddresses();--%>

<%--        // Close the modal--%>
<%--        addressEditModal.hide();--%>

<%--        // Reset form--%>
<%--        form.reset();--%>
<%--    });--%>

<%--    // Initial render--%>
<%--    renderAddresses();--%>
<%--</script>--%>
</body>
</html>
