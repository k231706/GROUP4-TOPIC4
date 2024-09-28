import React, { useState } from "react";

const DesignUploadPage = () => {
  // State để lưu thông tin khách hàng và các ảnh được tải lên
  const [customerName, setCustomerName] = useState("Tên Khách Hàng");
  const [phone, setPhone] = useState("0123456789");
  const [address, setAddress] = useState("123 Địa chỉ");
  const [images, setImages] = useState({
    image2D: null,
    image3D: null,
    frontView: null,
    rearView: null,
  });

  // Hàm xử lý khi chọn file
  const handleImageUpload = (event, imageType) => {
    const file = event.target.files[0];
    if (file) {
      setImages({
        ...images,
        [imageType]: URL.createObjectURL(file), // Hiển thị ảnh đã chọn
      });
    }
  };

  return (
    <div>
      <h1>Thông Tin Khách Hàng</h1>
      <p>Tên: {customerName}</p>
      <p>Số điện thoại: {phone}</p>
      <p>Địa chỉ: {address}</p>

      <h2>Tải Ảnh Design</h2>
      <div>
        <h3>Ảnh 2D</h3>
        <input
          type="file"
          accept="image/*"
          onChange={(e) => handleImageUpload(e, "image2D")}
        />
        {images.image2D && <img src={images.image2D} alt="Ảnh 2D" />}
      </div>

      <div>
        <h3>Ảnh 3D</h3>
        <input
          type="file"
          accept="image/*"
          onChange={(e) => handleImageUpload(e, "image3D")}
        />
        {images.image3D && <img src={images.image3D} alt="Ảnh 3D" />}
      </div>

      <div>
        <h3>Ảnh Nhìn Từ Trước</h3>
        <input
          type="file"
          accept="image/*"
          onChange={(e) => handleImageUpload(e, "frontView")}
        />
        {images.frontView && (
          <img src={images.frontView} alt="Ảnh Nhìn Từ Trước" />
        )}
      </div>

      <div>
        <h3>Ảnh Nhìn Từ Sau</h3>
        <input
          type="file"
          accept="image/*"
          onChange={(e) => handleImageUpload(e, "rearView")}
        />
        {images.rearView && <img src={images.rearView} alt="Ảnh Nhìn Từ Sau" />}
      </div>
    </div>
  );
};

export default DesignUploadPage;
