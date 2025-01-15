<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../common/taglib.jsp" %>
<html>
<head>
    <%@include file="/WEB-INF/views/common/user/head-link.jsp" %>
    <title>lịch sử bưu phẩm</title>
    <style>
        .dt-search {
            display: none;
        }
        .avatar-container {
            position: relative;
            display: inline-block;
            width: 150px;
            height: 150px;
        }

        .avatar-overlay {
            position: absolute;
            top: 0;
            left: 0;
            width: 150px;
            height: 150px;
            border-radius: 100%;
            background-color: rgba(54, 50, 50, 0.01);
            display: flex;
            justify-content: center;
            align-items: center;
            transition: background-color 0.3s ease;
        }

        .avatar-container:hover .avatar-overlay {
            background-color: rgba(0, 0, 0, 0.5);
        }

        .avatar-container:hover .avatar-overlay i {
            opacity: 1;
        }

        .avatar-overlay i {
            color: #dfe1e5;
            font-size: 24px;
            opacity: 0;
            transition: opacity 0.3s ease;
        }
        .img-preview {
            width: 150px;
            height: 150px;
            overflow: hidden;
        }

        .preview-container {
            text-align: center;
        }
        #previewArea {
            border: 1px solid #ddd;
        }
    </style>
</head>
<body>
<%-- Nav --%>
<%@include file="../common/user/navbar.jsp" %>
<%-- End Nav --%>


<%--content--%>
<main id="content">
    <div class="container p-4">
        <!-- Breadcrumb -->
        <section class="mb-4">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="/">Home</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Hồ sơ người dùng</li>
                </ol>
            </nav>
        </section>

        <!-- Profile Section -->
        <jsp:useBean id="customer" scope="request" type="com.rabex.express.model.Customer"/>
        <jsp:useBean id="user" scope="request" type="com.rabex.express.model.User"/>
        <section class="mb-4">
            <div class="row">
                <!-- Profile Card -->
                <div class="col-md-4 mb-3">
                    <div class="card h-100">
                        <div class="card-body text-center ">
                            <div class="avatar-container position-relative">
                                <img src="../../img/testimonial-1.jpg" class="rounded-circle img-fluid mb-3 avatar-img"
                                     style="width: 150px;" alt="User Avatar">
                                <!-- Thẻ <a> bao phủ overlay -->
                                <a class="btn avatar-overlay" href="#" data-mdb-ripple-init data-mdb-modal-init
                                   data-mdb-target="#profileEditModal">
                                    <i class="fas fa-edit me-2"></i>
                                </a>
                            </div>
                            <h5 class="card-title mb-2 mt-3">${user.fullName}</h5>
                            <p class="text-muted mb-1">Khách hàng</p>
                            <p class="text-muted">Thành viên từ ${user.createdAt}</p>
                        </div>
                    </div>
                </div>
                <!-- Profile Card Modal -->
                <div class="modal fade" id="profileEditModal" tabindex="-1" aria-labelledby="profileEditModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <!-- Modal Header -->
                            <div class="modal-header">
                                <h5 class="modal-title" id="profileEditModalLabel">Chỉnh sửa ảnh đại diện</h5>
                                <button type="button" class="btn-close" data-mdb-dismiss="modal"
                                        aria-label="Close"></button>
                            </div>

                            <!-- Modal Body -->
                            <div class="modal-body">
                                <form id="profileEditForm">
                                    <!-- Avatar -->
                                    <div class="mb-4">
                                        <label class="form-label" for="avatarUpload">Ảnh đại diện</label>
                                        <input type="file" id="avatarUpload" class="form-control" accept="image/*"/>
                                        <div class="form-text">Chọn ảnh định dạng: JPG, PNG, GIF (tối đa 2MB)</div>
                                        <div class="text-center mt-3">
                                            <img id="avatarPreview" src="../../img/testimonial-1.jpg"
                                                 class=" rounded-circle preview-img" style="width: 150px; height: 150px;" alt="Avatar Preview"/>

                                            <!-- Loading spinner (ẩn mặc định) -->
                                            <div class="spinner-border text-primary loading-spinner d-none"
                                                 role="status">
                                                <span class="visually-hidden">Loading...</span>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>

                            <!-- Modal Footer -->
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-mdb-dismiss="modal">Đóng</button>
                                <button type="button" class="btn btn-primary" id="saveChanges">Lưu thay đổi</button>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Profile Details -->
                <div class="col-md-8">
                    <div class="card mb-3">
                        <div class="card-body">
                            <div class="row mb-3">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Họ và tên</h6>
                                </div>
                                <div class="col-sm-9 text-secondary" data-field="user-name">
                                    ${user.fullName}
                                </div>
                            </div>
                            <hr>
                            <div class="row mb-3">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Email</h6>
                                </div>
                                <div class="col-sm-9 text-secondary" data-field="user-email">
                                    ${user.email}
                                </div>
                            </div>
                            <hr>
                            <div class="row mb-3">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Điện thoại</h6>
                                </div>
                                <div class="col-sm-9 text-secondary" data-field="user-phone">
                                    ${customer.phoneNumber}
                                </div>
                            </div>
                            <hr>
                            <div class="row mb-3">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Địa chỉ</h6>
                                </div>
                                <div class="col-sm-9 text-secondary" data-field="user-addr">
                                    214B Đường Tam Bình, Phường Tam Phú, Thủ Đức, TP.HCM
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-6">
                                    <a class="btn btn-outline-primary" href="#" data-mdb-ripple-init data-mdb-modal-init
                                       data-mdb-target="#profile-edit">
                                        <i class="fas fa-edit me-2"></i>Chỉnh sửa hồ sơ
                                    </a>
                                </div>
                                <div class="col-sm-6 d-flex justify-content-end">
                                    <a class="btn btn-outline-danger" href="#" data-mdb-ripple-init data-mdb-modal-init
                                       data-mdb-target="#profile-changePass">
                                        <i class=""></i>Đổi mật khẩu
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Profile Edit Modal -->
        <div class="modal fade" id="profile-edit" tabindex="-1" aria-labelledby="profile-edit" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h5 class="modal-title" id="profile-edit-label">Chỉnh sửa hồ sơ</h5>
                        <button type="button" class="btn-close" data-mdb-dismiss="modal" aria-label="Close"></button>
                    </div>

                    <!-- Modal Body -->
                    <div class="modal-body">
                        <form id="profile-edit-form">
                            <!-- Họ và tên -->
                            <div class="mb-4">
                                <label class="form-label" for="user-name">Họ và tên</label>
                                <input type="text" id="user-name" class="form-control" placeholder="Nhập họ và tên"
                                       value=""/>
                            </div>
                            <!-- Email -->
                            <div class="mb-4">
                                <label class="form-label" for="user-email">Email</label>
                                <input type="email" id="user-email" class="form-control"
                                       placeholder="nguyenvana@example.com" value=""/>
                            </div>

                            <!-- Điện thoại -->
                            <div class="mb-4">
                                <label class="form-label" for="user-phone">Điện thoại</label>
                                <input type="tel" id="user-phone" class="form-control" placeholder="0123 456 789"
                                       value=""/>
                            </div>

                            <!-- Địa chỉ -->
                            <div class="mb-4">
                                <label class="form-label" for="user-addr">Địa chỉ</label>
                                <textarea id="user-addr" class="form-control" rows="3" placeholder="Nhập địa chỉ">123 Đường ABC, Phường XYZ, Quận 1, TP.HCM</textarea>
                            </div>
                        </form>
                    </div>

                    <!-- Modal Footer -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-mdb-dismiss="modal">Đóng</button>
                        <button type="button" class="btn btn-primary" id="save-profile">Lưu thay đổi</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- Password Change Modal -->
        <div class="modal fade" id="profile-changePass" tabindex="-1" aria-labelledby="profile-changePass"
             aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h5 class="modal-title" id="profile-changePass-label">Đổi mật khẩu</h5>
                        <button type="button" class="btn-close" data-mdb-dismiss="modal" aria-label="Close"></button>
                    </div>

                    <!-- Modal Body -->
                    <div class="modal-body">
                        <form id="password-change-form">
                            <!-- Mật khẩu hiện tại -->
                            <div class="form-text mb-4">
                                <input type="password" id="current-password" class="form-control"/>
                                <label class="form-label" for="current-password">Mật khẩu hiện tại</label>
                            </div>

                            <!-- Mật khẩu mới -->
                            <div class="form-text mb-4">
                                <input type="password" id="new-password" class="form-control"/>
                                <label class="form-label" for="new-password">Mật khẩu mới</label>
                                <div class="form-helper">Mật khẩu phải có ít nhất 8 ký tự, bao gồm chữ hoa, chữ thường
                                    và số
                                </div>
                            </div>

                            <!-- Xác nhận mật khẩu mới -->
                            <div class="form-text mb-4">
                                <input type="password" id="confirm-password" class="form-control"/>
                                <label class="form-label" for="confirm-password">Xác nhận mật khẩu mới</label>
                            </div>
                        </form>
                    </div>

                    <!-- Modal Footer -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-mdb-dismiss="modal">Đóng</button>
                        <button type="button" class="btn btn-danger" id="save-password">Đổi mật khẩu</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Shop section -->
        <section class="mb-4">
            <div class="card">
                <div class="card-header text-black">
                    <h5 class="mb-0">Thông Tin Kinh Doanh</h5>
                </div>
                <div class="card-body">
                    <div class="row mb-3">
                        <div class="col-sm-3">
                            <h6 class="mb-0">Tên Công Ty</h6>
                        </div>
                        <div class="col-sm-9 text-secondary" data-field="company-name">
                            ${customer.companyName}
                        </div>
                    </div>
                    <hr>
                    <div class="row mb-3">
                        <div class="col-sm-3">
                            <h6 class="mb-0">Số lượng đơn ngày</h6>
                        </div>
                        <div class="col-sm-9 text-secondary">
                            -
                        </div>
                    </div>
                    <hr>
                    <div class="row mb-3">
                        <div class="col-sm-3">
                            <h6 class="mb-0">Ngành hàng</h6>
                        </div>
                        <div class="col-sm-9 text-secondary" data-field="industry">
                            ${customer.industry}
                        </div>
                    </div>
                    <hr>
                    <div class="row mb-3">
                        <div class="col-sm-3">
                            <h6 class="mb-0">Kênh bán hàng</h6>
                        </div>
                        <div class="col-sm-9 text-secondary" data-field="sales-channel">
                            ${customer.channel}
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12 d-flex justify-content-end">
                            <a class="btn btn-outline-primary" href="#" data-mdb-ripple-init data-mdb-modal-init
                               data-mdb-target="#shop-info">
                                <i class="fas fa-edit me-2"></i>Cập nhật
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Shop edit modal -->
        <div class="modal fade" id="shop-info" tabindex="-1" aria-labelledby="shop-info" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h5 class="modal-title" id="shop-info-label">Cập nhật Thông Tin Kinh Doanh</h5>
                        <button type="button" class="btn-close" data-mdb-dismiss="modal" aria-label="Close"></button>
                    </div>

                    <!-- Modal Body -->
                    <div class="modal-body">
                        <form id="shop-info-form">
                            <!-- Tên Công Ty -->
                            <div class="mb-3">
                                <label for="company-name" class="form-label">Tên Công Ty</label>
                                <input type="text" id="company-name" class="form-control" placeholder="Nhập tên công ty"
                                       value="Công Ty TNHH Rabex">
                            </div>

                            <!-- Ngành hàng -->
                            <div class="mb-3">
                                <label for="industry" class="form-label">Ngành hàng</label>
                                <input type="text" id="industry" class="form-control" placeholder="Nhập ngành hàng"
                                       value="">
                            </div>

                            <!-- Kênh bán hàng -->
                            <div class="mb-3">
                                <label for="sales-channel" class="form-label">Kênh bán hàng</label>
                                <input type="text" id="sales-channel" class="form-control"
                                       placeholder="Nhập kênh bán hàng" value="Tiktok">
                            </div>
                        </form>
                    </div>

                    <!-- Modal Footer -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-mdb-dismiss="modal">Đóng</button>
                        <button type="button" class="btn btn-primary" id="save-shop-info">Lưu thay đổi</button>
                    </div>
                </div>
            </div>
        </div>

    </div>
</main>
<%--content--%>

<script src="<c:url value='/static/js/mdb.umd.min.js'/>"></script>
<script src="https://cdn.jsdelivr.net/npm/quill@2.0.2/dist/quill.js"></script>
<script src="<c:url value='/static/js/main.js'/>"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/cropperjs/1.5.12/cropper.min.js"></script>
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
    document.addEventListener('DOMContentLoaded', function () {
        // Khởi tạo các components của MDB
        document.querySelectorAll('.toast').forEach(toastElement => {
            new mdb.Toast(toastElement);
        });

        const avatarUpload = document.getElementById('avatarUpload');
        const avatarPreview = document.getElementById('avatarPreview');
        const saveChanges = document.getElementById('saveChanges');
        const profileEditForm = document.getElementById('profileEditForm');
        const avatarImg = document.querySelector('.avatar-img');
        const loadingSpinner = document.querySelector('.loading-spinner');
        const modal = new mdb.Modal(document.getElementById('profileEditModal'));

        // Function để hiển thị thông báo
        function showNotification(message, type = 'success') {
            const toastHTML = `
      <div class="toast align-items-center text-white bg-${type} border-0" role="alert" aria-live="assertive" aria-atomic="true">
        <div class="d-flex">
          <div class="toast-body">${message}</div>
          <button type="button" class="btn-close btn-close-white me-2 m-auto" data-mdb-dismiss="toast"></button>
        </div>
      </div>
    `;

            const toastContainer = document.querySelector('.toast-container') || createToastContainer();
            const toastElement = createElementFromHTML(toastHTML);
            toastContainer.appendChild(toastElement);

            const toast = new mdb.Toast(toastElement);
            toast.show();

            // Tự động xóa toast sau khi ẩn
            toastElement.addEventListener('hidden.mdb.toast', () => {
                toastElement.remove();
            });
        }

        // Tạo container cho toast nếu chưa tồn tại
        function createToastContainer() {
            const container = document.createElement('div');
            container.className = 'toast-container';
            document.body.appendChild(container);
            return container;
        }

        // Helper function để tạo element từ HTML string
        function createElementFromHTML(htmlString) {
            const div = document.createElement('div');
            div.innerHTML = htmlString.trim();
            return div.firstChild;
        }

        // Xem trước ảnh khi chọn file
        avatarUpload.addEventListener('change', function (e) {
            const file = e.target.files[0];
            if (file) {
                // Kiểm tra kích thước file
                if (file.size > 2 * 1024 * 1024) {
                    showNotification('Kích thước file không được vượt quá 2MB', 'danger');
                    this.value = '';
                    return;
                }

                // Kiểm tra định dạng file
                const validTypes = ['image/jpeg', 'image/png', 'image/gif'];
                if (!validTypes.includes(file.type)) {
                    showNotification('Vui lòng chọn file ảnh định dạng JPG, PNG hoặc GIF', 'danger');
                    this.value = '';
                    return;
                }

                const reader = new FileReader();
                reader.onload = function (e) {
                    avatarPreview.src = e.target.result;
                    avatarPreview.style.display = 'block';
                    loadingSpinner.classList.add('d-none');
                };

                // Hiển thị loading khi đang đọc file
                avatarPreview.style.display = 'none';
                loadingSpinner.classList.remove('d-none');

                reader.readAsDataURL(file);
            }
        });

        // Xử lý khi nhấn nút lưu
        saveChanges.addEventListener('click', function () {
            const fileInput = avatarUpload.files[0];
            if (fileInput) {
                // Hiển thị loading
                loadingSpinner.classList.remove('d-none');
                avatarPreview.style.display = 'none';
                saveChanges.disabled = true;

                // Giả lập việc upload file (thay thế bằng API call thực tế)
                setTimeout(() => {
                    avatarImg.src = avatarPreview.src;

                    // Ẩn loading
                    loadingSpinner.classList.add('d-none');
                    avatarPreview.style.display = 'block';
                    saveChanges.disabled = false;

                    // Đóng modal
                    modal.hide();

                    // Reset form
                    profileEditForm.reset();

                    // Hiển thị thông báo thành công
                    showNotification('Cập nhật ảnh đại diện thành công!');
                }, 1500);
            } else {
                showNotification('Vui lòng chọn ảnh để upload', 'warning');
            }
        });
    });

    // Nút cập nhật thông tin doanh nghiệp
    document.getElementById('save-shop-info').addEventListener('click', function () {
        // Lấy giá trị từ các input
        const companyName = document.getElementById('company-name').value;
        const industry = document.getElementById('industry').value;
        const salesChannel = document.getElementById('sales-channel').value;

        // Cập nhật dữ liệu hiển thị trong phần Thông Tin Kinh Doanh
        document.querySelector('[data-field="company-name"]').textContent = companyName || '-';
        document.querySelector('[data-field="industry"]').textContent = industry || '-';
        document.querySelector('[data-field="sales-channel"]').textContent = salesChannel || '-';

        // Tạo container cho toast nếu chưa tồn tại
        let toastContainer = document.querySelector('.toast-container');
        if (!toastContainer) {
            toastContainer = document.createElement('div');
            toastContainer.className = 'toast-container position-fixed bottom-0 end-0 p-3';
            document.body.appendChild(toastContainer);
        }

        // Tạo toast element
        const toastDiv = document.createElement('div');
        toastDiv.className = 'toast fade';
        toastDiv.setAttribute('role', 'alert');
        toastDiv.setAttribute('aria-live', 'assertive');
        toastDiv.setAttribute('aria-atomic', 'true');
        toastDiv.setAttribute('data-mdb-autohide', 'true');
        toastDiv.setAttribute('data-mdb-delay', '3000');
        toastDiv.setAttribute('data-mdb-position', 'top-center');

        toastDiv.innerHTML = `
        <div class="toast-header">
            <i class="fas fa-check me-2 text-success"></i>
            <strong class="me-auto">Thông báo</strong>
            <button type="button" class="btn-close" data-mdb-dismiss="toast" aria-label="Close"></button>
        </div>
        <div class="toast-body">
            Thông tin đã được cập nhật thành công!
        </div>
    `;

        toastContainer.appendChild(toastDiv);

        // Khởi tạo và hiển thị toast sử dụng MDB
        const toast = new mdb.Toast(toastDiv);
        toast.show();

        // Xóa toast element sau khi ẩn
        toastDiv.addEventListener('hidden.mdb.toast', function () {
            toastDiv.remove();
        });

        // Đóng modal
        const shopModal = mdb.Modal.getInstance(document.getElementById('shop-info'));
        if (shopModal) {
            shopModal.hide();
        }
    });

    // Thêm sự kiện click cho nút chỉnh sửa hồ sơ
    document.querySelector('a.btn-outline-primary').addEventListener('click', function (e) {
        e.preventDefault();
        const profileModal = new mdb.Modal(document.getElementById('profile-edit'));
        profileModal.show();
    });

    // Khởi tạo các form-outline của MDB
    document.querySelectorAll('.form-outline').forEach((formOutline) => {
        new mdb.Input(formOutline).init();
    });

    // Xử lý sự kiện lưu thông tin
    document.getElementById('save-profile').addEventListener('click', function () {
        // Lấy giá trị từ các input
        const userName = document.getElementById('user-name').value;
        const userEmail = document.getElementById('user-email').value;
        const userPhone = document.getElementById('user-phone').value;
        const userAddr = document.getElementById('user-addr').value;

        // Cập nhật thông tin trên trang
        document.querySelector('[data-field="user-name"]').textContent = userName;
        document.querySelector('.card-title').textContent = userName;
        document.querySelector('[data-field="user-email"]').textContent = userEmail;
        document.querySelector('[data-field="user-phone"]').textContent = userPhone;
        document.querySelector('[data-field="user-addr"]').textContent = userAddr;

        // Tạo container cho toast nếu chưa tồn tại
        let toastContainer = document.querySelector('.toast-container');
        if (!toastContainer) {
            toastContainer = document.createElement('div');
            toastContainer.className = 'toast-container position-fixed bottom-0 end-0 p-3';
            document.body.appendChild(toastContainer);
        }

        // Tạo toast element
        const toastDiv = document.createElement('div');
        toastDiv.className = 'toast fade';
        toastDiv.setAttribute('role', 'alert');
        toastDiv.setAttribute('aria-live', 'assertive');
        toastDiv.setAttribute('aria-atomic', 'true');
        toastDiv.setAttribute('data-mdb-autohide', 'true');
        toastDiv.setAttribute('data-mdb-delay', '3000');
        toastDiv.setAttribute('data-mdb-position', 'top-center');

        toastDiv.innerHTML = `
        <div class="toast-header">
            <i class="fas fa-check me-2 text-success"></i>
            <strong class="me-auto">Thông báo</strong>
            <button type="button" class="btn-close" data-mdb-dismiss="toast" aria-label="Close"></button>
        </div>
        <div class="toast-body">
            Thông tin hồ sơ đã được cập nhật thành công!
        </div>
    `;

        toastContainer.appendChild(toastDiv);

        // Khởi tạo và hiển thị toast
        const toast = new mdb.Toast(toastDiv);
        toast.show();

        // Xóa toast element sau khi ẩn
        toastDiv.addEventListener('hidden.mdb.toast', function () {
            toastDiv.remove();
        });

        // Đóng modal
        const profileModal = mdb.Modal.getInstance(document.getElementById('profile-edit'));
        if (profileModal) {
            profileModal.hide();
        }
    });

    // Khởi tạo các form-outline của MDB cho modal đổi mật khẩu
    document.querySelectorAll('.form-text').forEach((formOutline) => {
        new mdb.Input(formOutline).init();
    });

    // Xử lý sự kiện đổi mật khẩu
    document.getElementById('save-password').addEventListener('click', function () {
        // Lấy giá trị từ các input
        const currentPassword = document.getElementById('current-password').value;
        const newPassword = document.getElementById('new-password').value;
        const confirmPassword = document.getElementById('confirm-password').value;

        // Validate form
        let isValid = true;
        let errorMessage = '';

        // Kiểm tra mật khẩu hiện tại
        if (!currentPassword) {
            isValid = false;
            errorMessage = 'Vui lòng nhập mật khẩu hiện tại';
        }

        // Kiểm tra mật khẩu mới
        const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/;
        if (!passwordRegex.test(newPassword)) {
            isValid = false;
            errorMessage = 'Mật khẩu mới phải có ít nhất 8 ký tự, bao gồm chữ hoa, chữ thường và số';
        }

        // Kiểm tra xác nhận mật khẩu
        if (newPassword !== confirmPassword) {
            isValid = false;
            errorMessage = 'Xác nhận mật khẩu không khớp';
        }

        // Nếu có lỗi, hiển thị thông báo và dừng xử lý
        if (!isValid) {
            // Tạo và hiển thị toast error
            showToast('Lỗi', errorMessage, 'error');
            return;
        }

        // Nếu form hợp lệ, xử lý đổi mật khẩu
        // TODO: Thêm API call để đổi mật khẩu ở đây

        // Reset form
        document.getElementById('password-change-form').reset();

        // Hiển thị thông báo thành công
        showToast('Thành công', 'Mật khẩu đã được thay đổi thành công', 'success');

        // Đóng modal
        const passwordModal = mdb.Modal.getInstance(document.getElementById('profile-changePass'));
        if (passwordModal) {
            passwordModal.hide();
        }
    });

    // Hàm hiển thị toast
    function showToast(title, message, type = 'success') {
        // Tạo container cho toast nếu chưa tồn tại
        let toastContainer = document.querySelector('.toast-container');
        if (!toastContainer) {
            toastContainer = document.createElement('div');
            toastContainer.className = 'toast-container position-fixed bottom-0 end-0 p-3';
            document.body.appendChild(toastContainer);
        }

        // Tạo toast element
        const toastDiv = document.createElement('div');
        toastDiv.className = 'toast fade';
        toastDiv.setAttribute('role', 'alert');
        toastDiv.setAttribute('aria-live', 'assertive');
        toastDiv.setAttribute('aria-atomic', 'true');
        toastDiv.setAttribute('data-mdb-autohide', 'true');
        toastDiv.setAttribute('data-mdb-delay', '3000');
        toastDiv.setAttribute('data-mdb-position', 'top-right');

        const icon = type === 'success' ? 'fa-check text-success' : 'fa-exclamation-circle text-danger';

        toastDiv.innerHTML = `
        <div class="toast-header">
            <i class="fas ${icon} me-2"></i>
            <strong class="me-auto">${title}</strong>
            <button type="button" class="btn-close" data-mdb-dismiss="toast" aria-label="Close"></button>
        </div>
        <div class="toast-body">
            ${message}
        </div>
    `;

        toastContainer.appendChild(toastDiv);

        // Khởi tạo và hiển thị toast
        const toast = new mdb.Toast(toastDiv);
        toast.show();

        // Xóa toast element sau khi ẩn
        toastDiv.addEventListener('hidden.mdb.toast', function () {
            toastDiv.remove();
        });
    }

    document.addEventListener('DOMContentLoaded', function () {
        // Avatar upload functionality
        const avatarContainer = document.querySelector('.avatar-container');
        const avatarUpload = document.getElementById('avatarUpload');
        const avatarPreview = document.getElementById('avatarPreview');
        const saveAvatarBtn = document.getElementById('saveChanges');
        const loadingSpinner = document.querySelector('.loading-spinner');

        // Kích hoạt upload file khi click vào avatar
        avatarContainer.addEventListener('click', function () {
            avatarUpload.click();
        });

        // Xem trước ảnh
        avatarUpload.addEventListener('change', function (event) {
            const file = event.target.files[0];
            if (file) {
                // Kiểm tra kích thước file
                if (file.size > 2 * 1024 * 1024) {
                    alert('Vui lòng chọn ảnh dung lượng nhỏ hơn 2MB');
                    avatarUpload.value = '';
                    return;
                }

                // Kiểm tra định dạng file
                const allowedTypes = ['image/jpeg', 'image/png', 'image/gif'];
                if (!allowedTypes.includes(file.type)) {
                    alert('Vui lòng chọn ảnh có định dạng JPG, PNG hoặc GIF');
                    avatarUpload.value = '';
                    return;
                }

                const reader = new FileReader();
                reader.onload = function (e) {
                    avatarPreview.src = e.target.result;
                };
                reader.readAsDataURL(file);
            }
        });

        // Profile edit and avatar save functionality
        document.getElementById('save-profile').addEventListener('click', function () {
            // Lấy giá trị từ các input
            const userName = document.getElementById('user-name').value;
            const userEmail = document.getElementById('user-email').value;
            const userPhone = document.getElementById('user-phone').value;
            const userAddr = document.getElementById('user-addr').value;
            const avatarFile = avatarUpload.files[0];

            // Cập nhật thông tin trên trang
            document.querySelector('[data-field="user-name"]').textContent = userName;
            document.querySelector('.card-title').textContent = userName;
            document.querySelector('[data-field="user-email"]').textContent = userEmail;
            document.querySelector('[data-field="user-phone"]').textContent = userPhone;
            document.querySelector('[data-field="user-addr"]').textContent = userAddr;

            // Cập nhật avatar nếu có
            if (avatarFile) {
                const reader = new FileReader();
                reader.onload = function (e) {
                    document.querySelector('.avatar-img').src = e.target.result;
                };
                reader.readAsDataURL(avatarFile);
            }

            // Tạo container cho toast nếu chưa tồn tại
            let toastContainer = document.querySelector('.toast-container');
            if (!toastContainer) {
                toastContainer = document.createElement('div');
                toastContainer.className = 'toast-container position-fixed bottom-0 end-0 p-3';
                document.body.appendChild(toastContainer);
            }

            // Tạo toast element
            const toastDiv = document.createElement('div');
            toastDiv.className = 'toast fade';
            toastDiv.setAttribute('role', 'alert');
            toastDiv.setAttribute('aria-live', 'assertive');
            toastDiv.setAttribute('aria-atomic', 'true');
            toastDiv.setAttribute('data-mdb-autohide', 'true');
            toastDiv.setAttribute('data-mdb-delay', '3000');
            toastDiv.setAttribute('data-mdb-position', 'top-center');
            toastDiv.innerHTML = `
            <div class="toast-header">
                <i class="fas fa-check me-2 text-success"></i>
                <strong class="me-auto">Thông báo</strong>
                <button type="button" class="btn-close" data-mdb-dismiss="toast" aria-label="Close"></button>
            </div>
            <div class="toast-body">
                Thông tin hồ sơ đã được cập nhật thành công!
            </div>
        `;
            toastContainer.appendChild(toastDiv);

            // Khởi tạo và hiển thị toast
            const toast = new mdb.Toast(toastDiv);
            toast.show();

            // Xóa toast element sau khi ẩn
            toastDiv.addEventListener('hidden.mdb.toast', function () {
                toastDiv.remove();
            });

            // Đóng modal
            const profileModal = mdb.Modal.getInstance(document.getElementById('profile-edit'));
            if (profileModal) {
                profileModal.hide();
            }
        });
    });
</script>

</body>
</html>
