<%--@elvariable id="customer" type="com.rabex.express.model.Customer"--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../common/taglib.jsp" %>
<html>
<head>
    <%@include file="/WEB-INF/views/user/common/head-link.jsp" %>
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
<%@include file="common/navbar.jsp" %>
<%-- End Nav --%>


<!-- content  -->
<main id="content">
    <div class="container p-4">
        <section class="mb-4">
            <div class="card">
                <div class="card-header bg-white">
                    <h5 style="font-size: 24px;">Quản lý địa chỉ</h5>
                </div>
                <div class="card-body">
                    <!-- Form thêm địa chỉ -->
                    <form id="add-address-form">
                        <a class="btn btn-outline-primary" href="#" data-mdb-ripple-init data-mdb-modal-init
                           data-mdb-target="#address-add">
                            <i class="fas fa-edit me-2"></i>Thêm địa chỉ mới
                        </a>
                    </form>

                    <!-- Address Add Modal -->
                    <div class="modal fade" id="address-add" tabindex="-1" aria-labelledby="address-add"
                         aria-hidden="true">
                        <div class="modal-dialog">
                            <form class="modal-content" action="<c:url value="/nguoi-dung/dia-chi"/>" method="post">
                                <!-- Modal Header -->
                                <div class="modal-header">
                                    <h5 class="modal-title">Thêm địa chỉ mới</h5>
                                    <button type="button" class="btn-close" data-mdb-dismiss="modal"
                                            aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <div id="address-form">
                                        <input type="hidden" id="address-index">

                                        <div class="row mb-3">
                                            <div class="col-md-4">
                                                <label class="form-label" for="fullName">Tên</label>
                                                <input type="text" class="form-control" id="fullName" name="fullName"
                                                >
                                            </div>
                                            <div class="col-md-4">
                                                <label class="form-label" for="phone">Số điện thoại</label>
                                                <input type="tel" class="form-control" id="phone" name="phoneNumber"
                                                >
                                            </div>
                                            <div class="col-md-4">
                                                <label class="form-label" for="address-type">Loại địa chỉ</label>
                                                <select id="address-type" class="form-select" name="addressType">
                                                    <option value="PRIVATE_HOUSE">Nhà riêng</option>
                                                    <option value="OFFICE">Văn phòng</option>
                                                    <option value="DIFFERENT">Khác</option>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="row mb-3">
                                            <label class="form-label" for="add-address-picker">Địa chỉ</label>
                                            <div class="dropdown" id="add-address-picker"></div>
                                        </div>
                                        <div class="mb-3">
                                            <label class="form-label" for="address">Địa chỉ chi tiết</label>
                                            <input type="text" class="form-control" id="address" name="description">
                                        </div>
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox" id="default-address"
                                                   name="addressDefault" value="true">
                                            <label class="form-check-label" for="default-address">
                                                Đặt làm địa chỉ mặc định
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-mdb-dismiss="modal">Đóng
                                    </button>
                                    <form action="<c:url value="/nguoi-dung/dia-chi"/>" method="post">
                                    <button type="submit" class="btn btn-primary" id="save-address">Lưu địa chỉ</button>
                                    </form>
                                </div>
                            </form>
                        </div>
                    </div>

                    <!-- Address Edit Modal -->
                    <div class="modal fade" id="address-edit" tabindex="-1"
                         aria-labelledby="address-edit"
                         aria-hidden="true">
                        <div class="modal-dialog">
                            <form id="edit-address-form" class="modal-content"
                                  action="<c:url value="/nguoi-dung/dia-chi?action=edit"/>" method="post">
                                <!-- Thêm input hidden để lưu ID -->
                                <input type="hidden" name="addressId" id="edit-address-id">
                                <input type="hidden" name="personInfoId" id="edit-person-info-id">
                                <!-- Modal Header -->
                                <div class="modal-header">
                                    <h5 class="modal-title">Chỉnh sửa địa chỉ</h5>
                                    <button type="button" class="btn-close" data-mdb-dismiss="modal"
                                            aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <div id="edit-address-body">
                                        <input type="hidden" id="edit-address-index">

                                        <div class="row mb-3">
                                            <div class="col-md-4">
                                                <label class="form-label"
                                                       for="fullName-edit">Tên</label>
                                                <input type="text" class="form-control"
                                                       id="fullName-edit" name="fullName" required>
                                            </div>
                                            <div class="col-md-4">
                                                <label class="form-label" for="phone">Số điện
                                                    thoại</label>
                                                <input type="tel" class="form-control" id="phone-edit"
                                                       name="phoneNumber" required>
                                            </div>
                                            <div class="col-md-4">
                                                <label class="form-label" for="address-type-edit">Loại
                                                    địa chỉ</label>
                                                <select id="address-type-edit" class="form-select"
                                                        name="addressType" required>
                                                    <option value="PRIVATE_HOUSE">Nhà riêng</option>
                                                    <option value="OFFICE">Văn phòng</option>
                                                    <option value="DIFFERENT">Khác</option>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="row mb-3">
                                            <label class="form-label" for="edit-address-picker">Địa chỉ</label>
                                            <div class="dropdown" id="edit-address-picker" required></div>
                                            <input type="hidden" name="province" id="province-hidden">
                                            <input type="hidden" name="district" id="district-hidden">
                                            <input type="hidden" name="ward" id="ward-hidden">
                                        </div>

                                        <div class="mb-3">
                                            <label class="form-label" for="address-des-edit">Địa chỉ chi
                                                tiết</label>
                                            <input type="text" class="form-control"
                                                   id="address-des-edit"
                                                   name="description" required>
                                        </div>
                                        <div class="form-check">
                                            <input type="hidden" name="addressDefault" value="false">
                                            <input class="form-check-input" type="checkbox"
                                                   id="default-address-edit" name="addressDefault"
                                                   value="true">
                                            <label class="form-check-label" for="default-address-edit">
                                                Đặt làm địa chỉ mặc định
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary"
                                            data-mdb-dismiss="modal">Đóng
                                    </button>
                                    <form action="<c:url value="/nguoi-dung/dia-chi?action=edit"/>" method="post">
                                    <button type="submit" class="btn btn-primary" id="save-address-edit">
                                        Lưu địa chỉ
                                    </button>
                                    </form>
                                </div>
                            </form>
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
                                <th></th>
                            </tr>
                            </thead>
                            <tbody id="address-container">
                            <jsp:useBean id="customer" scope="request" type="com.rabex.express.model.Customer"/>
                            <c:forEach var="address" items="${customer.addresses}" varStatus="status">
                                <tr>
                                    <td>${status.index + 1}</td>
                                    <td>${address.personInfo.fullName}</td>
                                    <td>${address.personInfo.phoneNumber}</td>
                                    <td>${address.address.description},
                                            ${address.address.ward},
                                            ${address.address.district},
                                            ${address.address.province}
                                    </td>
                                    <td>
                                        <c:set var="type" value="${address.address.addressType}"/>
                                            ${type == 'PRIVATE_HOUSE' ? 'Nhà riêng' : type == 'OFFICE' ? 'Văn phòng' : type == 'DIFFERENT' ? 'Khác' : type}
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${customer.defaultAddressId == address.address.id}">
                                                Mặc định
                                            </c:when>
                                            <c:otherwise>
                                                <!-- Không hiển thị gì -->
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <button type="button"
                                                class="btn btn-sm btn-outline-primary edit-address"
                                                data-mdb-ripple-init
                                                data-mdb-modal-init
                                                data-mdb-target="#address-edit"
                                                data-id="${address.address.id}"
                                                data-person-info-id="${address.personInfo.id}"
                                                data-fullname="${address.personInfo.fullName}"
                                                data-phone="${address.personInfo.phoneNumber}"
                                                data-description="${address.address.description}"
                                                data-ward="${address.address.ward}"
                                                data-district="${address.address.district}"
                                                data-province="${address.address.province}"
                                                data-type="${address.address.addressType}"
                                                data-default="${customer.defaultAddressId == address.address.id}">
                                            <i class="fas fa-edit me-1"></i>
                                        </button>
                                        <form action="/nguoi-dung/dia-chi?action=delete" method="post">
                                            <input hidden="hidden" name="addressId" value="${address.address.id}">
                                            <input hidden="hidden" name="personInfoId" value="${address.personInfo.id}">
                                            <button type="submit" class="btn btn-sm btn-outline-danger remove-address"
                                                    data-id="${address.address.id}">
                                                <i class="fas fa-trash me-1"></i>
                                            </button>
                                        </form>
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
<script src="<c:url value="/static/js/address.dropdown.js"/>"></script>
<script src="<c:url value="/static/data/dvhc.json"/>"></script>

<script>
    const addressPicker = new AddressDropdown("#add-address-picker", {
        url: "<c:url value='/static/data/dvhc.json'/>",
        placeholder: "address",
        name: "address"
    })
    addressPicker.init()

    const sidenav = document.getElementById("main-sidenav");

    const sidenavInstance = mdb.Sidenav.getInstance(sidenav);

    const currencyFormat = Intl.NumberFormat("vi-VN", {style: 'currency', currency: 'VND'})


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
</script>
<script>
    let editPicker = null;

    function handleOpenEditModal(button) {
        document.getElementById('edit-address-form').reset();

        // Lấy dữ liệu từ button
        const addressId = button.getAttribute('data-id');
        const personInfoId = button.getAttribute('data-person-info-id');
        const fullName = button.getAttribute('data-fullname');
        const phoneNumber = button.getAttribute('data-phone');
        const description = button.getAttribute('data-description');
        const ward = button.getAttribute('data-ward');
        const district = button.getAttribute('data-district');
        const province = button.getAttribute('data-province');
        const addressType = button.getAttribute('data-type');
        const isDefault = button.getAttribute('data-default') === 'true';

        // Cập nhật các trường input
        document.getElementById('edit-address-id').value = addressId;
        document.getElementById('edit-person-info-id').value = personInfoId;
        document.getElementById('fullName-edit').value = fullName;
        document.getElementById('phone-edit').value = phoneNumber;
        document.getElementById('address-des-edit').value = description;
        document.getElementById('address-type-edit').value = addressType;
        document.getElementById('default-address-edit').checked = isDefault;

        // Cập nhật hidden fields cho địa chỉ
        document.getElementById('province-hidden').value = province;
        document.getElementById('district-hidden').value = district;
        document.getElementById('ward-hidden').value = ward;

        // Tạo placeholder text từ các giá trị địa chỉ
        const placeholderText = province + " / " + district + " / " + ward;

        // Khởi tạo hoặc cập nhật AddressDropdown
        if (editPicker) {
            // Hủy instance cũ
            editPicker.destroy && editPicker.destroy();
        }

        editPicker = new AddressDropdown("#edit-address-picker", {
            url: "/static/data/dvhc.json",
            placeholder: placeholderText,
            name: "address",
            defaultValue: {
                province: province,
                district: district,
                ward: ward
            }
        });

        editPicker.init();
        //
        // // Thêm event listener cho sự thay đổi địa chỉ
        // editPicker.onChange((selected) => {
        //     document.getElementById('province-hidden').value = selected.province || '';
        //     document.getElementById('district-hidden').value = selected.district || '';
        //     document.getElementById('ward-hidden').value = selected.ward || '';
        // });
    }

    // Xử lý sự kiện đóng modal
    document.querySelector('#address-edit').addEventListener('hidden.bs.modal', function () {
        if (editPicker) {
            editPicker.destroy && editPicker.destroy();
            editPicker = null;
        }
    });

    // Thêm event listeners khi trang được load
    document.addEventListener('DOMContentLoaded', function () {
        // Gắn sự kiện cho tất cả các nút edit
        const editButtons = document.querySelectorAll('.edit-address');
        editButtons.forEach(button => {
            button.addEventListener('click', function (e) {
                e.preventDefault();
                handleOpenEditModal(this);
            });
        });
    });

    document.addEventListener('DOMContentLoaded', () => {
        // Handle delete address
        const deleteButtons = document.querySelectorAll('.remove-address');
        deleteButtons.forEach(button => {
            button.addEventListener('click', (e) => {
                e.preventDefault(); // Prevent form submit default behavior

                if (confirm('Bạn có chắc chắn muốn xóa địa chỉ này?')) {
                    const form = button.closest('form');
                    form.submit();
                }
            });
        });

        // Handle form validation
        const addressForm = document.querySelector('#address-add form');
        if (addressForm) {
            addressForm.addEventListener('submit', (e) => {
                // Get all required fields
                const requiredFields = addressForm.querySelectorAll('[required]');
                let isValid = true;

                // Check each required field
                requiredFields.forEach(field => {
                    if (!field.value.trim()) {
                        isValid = false;
                        field.classList.add('is-invalid');
                    } else {
                        field.classList.remove('is-invalid');
                    }
                });

                if (!isValid) {
                    e.preventDefault();
                    alert('Vui lòng điền đầy đủ thông tin bắt buộc!');
                }
            });
        }
    })
</script>
</body>
</html>
