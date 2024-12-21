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
    <div class="container p-4">
        <section class="mb-4">
            <div class="card">
                <div class="card-header bg-white">
                    <h5 style="font-size: 24px;">Quản lý địa chỉ</h5>
                </div>
                <div class="card-body">
                    <!-- Form thêm địa chỉ -->
                    <form id="add-address-form">
                        <a class="btn btn-outline-primary" href="#" data-mdb-ripple-init data-mdb-modal-init data-mdb-target="#address-edit">
                            <i class="fas fa-edit me-2"></i>Thêm địa chỉ mới
                        </a>
                    </form>

                    <!-- Address Edit Modal -->
                    <div class="modal fade" id="address-edit" tabindex="-1" aria-labelledby="address-edit" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <!-- Modal Header -->
                                <div class="modal-header">
                                    <h5 class="modal-title">Thêm địa chỉ mới</h5>
                                    <button type="button" class="btn-close" data-mdb-dismiss="modal" aria-label="Close"></button>
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
                                            <div class="col-md-4">
                                                <label class="form-label" for="province">Tỉnh/Thành phố</label>
                                                <select id="province" class="form-select" required>
                                                    <option value="">Chọn tỉnh/thành phố</option>
                                                    <option value="1">Hà Nội</option>
                                                    <option value="2">Hồ Chí Minh</option>
                                                    <option value="3">Đà Nẵng</option>
                                                </select>
                                            </div>
                                            <div class="col-md-4">
                                                <label class="form-label" for="district">Quận/Huyện</label>
                                                <select id="district" class="form-select" required>
                                                    <option value="">Chọn quận/huyện</option>
                                                </select>
                                            </div>
                                            <div class="col-md-4">
                                                <label class="form-label" for="ward">Phường/Xã</label>
                                                <input type="text" class="form-control" id="ward" required>
                                            </div>
                                        </div>

                                        <div class="mb-3">
                                            <label class="form-label" for="address">Địa chỉ chi tiết</label>
                                            <input type="text" class="form-control" id="address" required>
                                        </div>

                                        <div class="mb-3">
                                            <label class="form-label" for="delivery-instructions">Ghi chú giao hàng</label>
                                            <textarea class="form-control" id="delivery-instructions" rows="3"></textarea>
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
                                    <button type="button" class="btn btn-secondary" data-mdb-dismiss="modal">Đóng</button>
                                    <button type="button" class="btn btn-primary" id="save-address">Lưu địa chỉ</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <hr />

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
                            <!-- Các địa chỉ sẽ được thêm vào đây một cách động -->
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
<!--content -->

<script src="<c:url value='/static/js/mdb.umd.min.js'/>"></script>
<script src="https://cdn.jsdelivr.net/npm/quill@2.0.2/dist/quill.js"></script>
<script src="<c:url value='/static/js/main.js'/>"></script>
<script>
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

    // Handle save address button click
    document.getElementById('save-address').addEventListener('click', async function(e) {
        e.preventDefault();

        const saveButton = this;
        const form = document.getElementById('address-form');

        // Validate form
        if (!form.checkValidity()) {
            form.reportValidity();
            return;
        }

        try {
            // Show loading state
            saveButton.disabled = true;
            saveButton.innerHTML = '<span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span> Đang lưu...';

            // Gather form data
            const formData = {
                name: document.getElementById('name').value,
                phone: document.getElementById('phone').value,
                province: document.getElementById('province').options[document.getElementById('province').selectedIndex].text,
                district: document.getElementById('district').value,
                ward: document.getElementById('ward').value,
                address: document.getElementById('address').value,
                addressType: document.getElementById('address_type'),
                isDefault: document.getElementById('is_default').checked
            };

            // Send request to backend
            const response = await fetch('/dia-chi', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(formData)
            });

            const result = await response.json();

            if (result.success) {
                // Show success message using MDB alert
                const alertTemplate = `
                <div class="alert alert-success alert-dismissible fade show" role="alert">
                    <strong>Thành công!</strong> ${result.message}
                    <button type="button" class="btn-close" data-mdb-dismiss="alert" aria-label="Close"></button>
                </div>
            `;
                document.querySelector('.container').insertAdjacentHTML('afterbegin', alertTemplate);

                // Close modal
                const modal = mdb.Modal.getInstance(document.getElementById('address-edit'));
                modal.hide();

                // Refresh address list
                location.reload();
            } else {
                throw new Error(result.message);
            }

        } catch (error) {
            // Show error message
            const alertTemplate = `
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong>Lỗi!</strong> ${error.message}
                <button type="button" class="btn-close" data-mdb-dismiss="alert" aria-label="Close"></button>
            </div>
        `;
            document.querySelector('.container').insertAdjacentHTML('afterbegin', alertTemplate);
        } finally {
            // Reset button state
            saveButton.disabled = false;
            saveButton.innerHTML = 'Lưu địa chỉ';
        }
    });

    // Province-District cascade
    document.getElementById('province').addEventListener('change', function() {
        const districtSelect = document.getElementById('district');
        districtSelect.innerHTML = '<option value="">Chọn quận/huyện</option>';

        const districts = {
            '1': ['Ba Đình', 'Hoàn Kiếm', 'Hai Bà Trưng'],
            '2': ['Quận 1', 'Quận 2', 'Thủ Đức'],
            '3': ['Hải Châu', 'Thanh Khê', 'Sơn Trà']
        };

        if (this.value) {
            districts[this.value].forEach(district => {
                const option = new Option(district, district);
                districtSelect.add(option);
            });
        }
    });
</script>
</body>
</html>
