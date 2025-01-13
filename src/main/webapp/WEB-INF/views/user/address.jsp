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


<!-- content  -->
<main id="content">
    <div class="container p-4 mt-5">
        <section class="mt-4">
            <div class="card">
                <div class="card-header bg-white">
                    <h5 style="font-size: 24px;">Quản lý địa chỉ</h5>
                </div>
                <div class="card-body">
                    <!-- Form thêm địa chỉ -->
                    <form id="add-address-form">
                        <a class="btn btn-outline-primary" href="#" data-mdb-ripple-init data-mdb-modal-init
                           data-mdb-target="#address-edit">
                            <i class="fas fa-edit me-2"></i>Thêm địa chỉ mới
                        </a>
                    </form>

                    <!-- Address Edit Modal -->
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
                                                <label class="form-label" for="name">Tên</label>
                                                <input type="text" class="form-control" id="name" required>
                                            </div>
                                            <div class="col-md-4">
                                                <label class="form-label" for="phone">Số điện thoại</label>
                                                <input type="tel" class="form-control" id="phone" required>
                                            </div>
                                            <div class="col-md-4">
                                                <label class="form-label" for="address-type">Loại địa chỉ</label>
                                                <select id="address-type" class="form-select">
                                                    <option value="home">Nhà riêng</option>
                                                    <option value="work">Văn phòng</option>
                                                    <option value="other">Khác</option>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="row mb-3">
                                            <div class="col-md-12">
                                                <label class="form-label" for="add-address-picker">Dia chi</label>
                                            <%--     input name "address" formmat ward/district/province dung cat chuoi de lay cai thanh phan                                           n--%>
                                                <div id="add-address-picker"></div>
                                            </div>

                                        </div>

                                        <div class="mb-3">
                                            <label class="form-label" for="address">Địa chỉ chi tiết</label>
                                            <input type="text" class="form-control" id="address" required>
                                        </div>

                                        <div class="mb-3">
                                            <label class="form-label" for="delivery-instructions">Ghi chú giao
                                                hàng</label>
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
                    <!-- Address List Table -->
                    <div class="table-responsive">
                        <table class="table table-hover" id="address-table">
                            <thead>
                            <tr>
                                <th>STT</th>
                                <th>Tên</th>
                                <th>Số điện thoại</th>
                                <th>Địa chỉ</th>
                                <th>Loại địa chỉ</th>
                                <th>Mặc định</th>
                                <th>Hành động</th>
                            </tr>
                            </thead>
                            <tbody id="address-container">
                            <%--@elvariable id="customer" type="com.rabex.express.model.Customer"--%>
                            <c:forEach var="address" items="${customer.addresses}">
                                <tr>
                                    <td>${1}</td>
                                    <td>${address.personInfo.fullName}</td>
                                    <td>${address.personInfo.phoneNumber}</td>
                                    <td>${address.address.description},
                                            ${address.address.ward},
                                            ${address.address.district},
                                            ${address.address.province}
                                    </td>
                                    <td>${address.address.addressType}</td>
                                    <td>
<%--                                        <span class="badge rounded-pill ${customer.defaultAddressId ? 'bg-success' : 'bg-secondary'}">--%>
<%--                                                ${customer.defaultAddressId ? 'Mặc định' : 'Không mặc định'}--%>
<%--                                        </span>--%>
                                    </td>
                                    <td>
                                        <a class="btn btn-sm btn-outline-primary edit-address" data-id="${address.address.id}">
                                            <i class="fas fa-edit me-1"></i>
                                        </a>
                                        <a class="btn btn-sm btn-outline-danger remove-address" data-id="${address.address.id}">
                                            <i class="fas fa-trash me-1"></i>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </section>
    </div>
</main>
<!--content -->

<script src="<c:url value='/static/js/mdb.umd.min.js'/>"></script>
<script src="https://cdn.jsdelivr.net/npm/quill@2.0.2/dist/quill.js"></script>
<script src="<c:url value='/static/js/main.js'/>"></script>
<script src="<c:url value='/static/js/address.dropdown.js'/>"></script>
<script>
    const sidenav = document.getElementById("main-sidenav");

    const sidenavInstance = mdb.Sidenav.getInstance(sidenav);

    const currencyFormat = Intl.NumberFormat("vi-VN", {style: 'currency', currency: 'VND'})
    const addAddressPicker = new AddressDropdown("#add-address-picker", {
        placeholder: "Chon dia chi",
        name: "address"
    });

    let innerWidth = null;

    //

    const setMode = (e) => {
        // Check necessary for Android devices
        if (window.innerWidth === innerWidth) {
            return;
        }

        innerWidth = window.innerWidth;

        if (window.innerWidth < 1400) {
            sidenavInstance.changeMode("over");
            sidenavInstance.hide();
        } else {
            sidenavInstance.changeMode("side");
            sidenavInstance.show();
        }
    };

    setMode();

    // Event listeners
    window.addEventListener("resize", setMode);

    const searchFocus = document.getElementById('search-focus');
    const keys = [
        {keyCode: 'AltLeft', isTriggered: false},
        {keyCode: 'ControlLeft', isTriggered: false},
    ];

    window.addEventListener('keydown', (e) => {
        keys.forEach((obj) => {
            if (obj.keyCode === e.code) {
                obj.isTriggered = true;
            }
        });

        const shortcutTriggered = keys.filter((obj) => obj.isTriggered).length === keys.length;

        if (shortcutTriggered) {
            searchFocus.focus();
        }
    });

    window.addEventListener('keyup', (e) => {
        keys.forEach((obj) => {
            if (obj.keyCode === e.code) {
                obj.isTriggered = false;
            }
        });
    });

    // Handle save address button click
    // JavaScript for managing address CRUD operations
    let addressList = [];

    // Fetch and render addresses on page load
    document.addEventListener('DOMContentLoaded', async () => {
        await fetchAddresses();
        renderTable();
    });

    // Function to fetch addresses from server
    async function fetchAddresses() {
        try {
            const response = await fetch('/dia-chi');
            if (!response.ok) throw new Error('Failed to fetch addresses');
            addressList = await response.json();
        } catch (error) {
            console.error('Error fetching addresses:', error);
        }
    }

    // Function to render the address table
    function renderTable() {
        const tableBody = document.querySelector('#addressTable tbody');
        tableBody.innerHTML = '';

        addressList.forEach((address, index) => {
            const row = document.createElement('tr');
            row.innerHTML = `
            <td>${index + 1}</td>
            <td>${address.description}</td>
            <td>${address.ward}</td>
            <td>${address.district}</td>
            <td>${address.province}</td>
            <td>${address.addressType}</td>
            <td>
                <button class="btn btn-warning btn-sm" onclick="onEdit(${index})">Edit</button>
                <button class="btn btn-danger btn-sm" onclick="onDelete(${index})">Delete</button>
            </td>
        `;
            tableBody.appendChild(row);
        });
    }

    // Function to handle adding or updating an address
    document.getElementById('saveButton').addEventListener('click', async () => {
        const description = document.getElementById('descriptionInput').value.trim();
        const ward = document.getElementById('wardInput').value.trim();
        const district = document.getElementById('districtInput').value.trim();
        const province = document.getElementById('provinceInput').value.trim();
        const addressType = document.getElementById('typeInput').value.trim();
        const index = document.getElementById('addressIndex').value;

        if (!description || !ward || !district || !province || !addressType) {
            alert('Please fill in all fields!');
            return;
        }

        const addressData = {description, ward, district, province, addressType};

        try {
            const method = index === '' ? 'POST' : 'PUT';
            const url = index === '' ? '/dia-chi' : `/dia-chi/${addressList[index].id}`;

            const response = await fetch(url, {
                method,
                headers: {'Content-Type': 'application/json'},
                body: JSON.stringify(addressData),
            });

            if (!response.ok) throw new Error('Failed to save address');

            alert('Address saved successfully!');
            await fetchAddresses();
            renderTable();
        } catch (error) {
            console.error('Error saving address:', error);
            alert('An error occurred while saving the address.');
        } finally {
            resetForm();
        }
    });

    // Function to edit an address
    function onEdit(index) {
        const address = addressList[index];

        document.getElementById('descriptionInput').value = address.description;
        document.getElementById('wardInput').value = address.ward;
        document.getElementById('districtInput').value = address.district;
        document.getElementById('provinceInput').value = address.province;
        document.getElementById('typeInput').value = address.addressType;
        document.getElementById('addressIndex').value = index;

        const modal = new bootstrap.Modal(document.getElementById('addressModal'));
        modal.show();
    }

    // Function to delete an address
    async function onDelete(index) {
        if (!confirm('Are you sure you want to delete this address?')) return;

        try {
            const response = await fetch(`/dia-chi/${addressList[index].id}`, {method: 'DELETE'});
            if (!response.ok) throw new Error('Failed to delete address');

            alert('Address deleted successfully!');
            await fetchAddresses();
            renderTable();
        } catch (error) {
            console.error('Error deleting address:', error);
            alert('An error occurred while deleting the address.');
        }
    }

    // Function to reset the form
    function resetForm() {
        document.getElementById('descriptionInput').value = '';
        document.getElementById('wardInput').value = '';
        document.getElementById('districtInput').value = '';
        document.getElementById('provinceInput').value = '';
        document.getElementById('typeInput').value = '';
        document.getElementById('addressIndex').value = '';
    }

</script>
<script>
    document.addEventListener('DOMContentLoaded', () => {
        const deleteButtons = document.querySelectorAll('.remove-address');
        deleteButtons.forEach(button => {
            button.addEventListener('click', () => {
                const addressId = button.getAttribute('data-id');
                if (confirm('Bạn có chắc chắn muốn xóa địa chỉ này?')) {
                    fetch(`/dia-chi/${addressId}`, {
                        method: 'DELETE',
                    })
                        .then(response => {
                            if (response.ok) {
                                alert('Địa chỉ đã được xóa thành công!');
                                location.reload(); // Tải lại trang để cập nhật danh sách
                            } else {
                                alert('Xóa địa chỉ thất bại!');
                            }
                        })
                        .catch(error => {
                            console.error('Lỗi:', error);
                            alert('Đã xảy ra lỗi khi xóa địa chỉ.');
                        });
                }
            });
        });
    });
</script>
</body>
</html>
