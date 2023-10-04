import React, { useState, useEffect } from "react";
import axios from "axios";

function MyPage() {
  const [userData, setUserData] = useState({});

  useEffect(() => {
    // 서버에서 데이터 가져오기
    axios
      .get("/members/me")
      .then((response) => {
        setUserData(response.data);
      })
      .catch((error) => {
        console.error("데이터를 가져오는 중 오류 발생:", error);
      });
  }, []);

  return (
    <div>
      <h1>마이페이지</h1>
      <p>Email: {userData.email}</p>
      <p>Name: {userData.name}</p>
      <p>Nickname: {userData.nickname}</p>
    </div>
  );
}

export default MyPage;
