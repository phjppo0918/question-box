import React, { useState } from 'react';
import { Form, Button, Container, Row, Col, Alert } from 'react-bootstrap';

const SignUpForm = () => {
  const [formData, setFormData] = useState({
    school: '',
    studentNumber: '',
    schoolEmail: '',
    name: '',
    password: '',
    confirmPassword: '', 
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };
  
  const [passwordMatch, setPasswordMatch] = useState(true);

  const handleSubmit = (e) => {
    e.preventDefault();

    // 비밀번호와 비밀번호 확인이 일치하는지 확인
    if (formData.password !== formData.confirmPassword) {
      setPasswordMatch(false);
      return;
    }

    // 여기서 폼 데이터를 처리하는 코드를 작성합니다.
    // formData 객체에 사용자가 입력한 값이 저장되어 있습니다.
    console.log(formData);

    // 비밀번호 일치 여부 초기화
    setPasswordMatch(true);
  };

  return (
    <Container>
      <Row className="justify-content-center">
        <Col md={6}>
          <Form onSubmit={handleSubmit}>
            <Form.Group controlId="school">
              <Form.Label>학교</Form.Label>
              <Form.Control
                type="text"
                name="school"
                value={formData.school}
                onChange={handleChange}
                required
              />
            </Form.Group>

            <Form.Group controlId="studentNumber">
              <Form.Label>학번</Form.Label>
              <Form.Control
                type="text"
                name="studentNumber"
                value={formData.studentNumber}
                onChange={handleChange}
                required
              />
            </Form.Group>

            <Form.Group controlId="schoolEmail">
              <Form.Label>학교 이메일</Form.Label>
              <Form.Control
                type="email"
                name="schoolEmail"
                value={formData.schoolEmail}
                onChange={handleChange}
                required
              />
            </Form.Group>

            <Form.Group controlId="name">
              <Form.Label>이름</Form.Label>
              <Form.Control
                type="text"
                name="name"
                value={formData.name}
                onChange={handleChange}
                required
              />
            </Form.Group>

            <Form.Group controlId="password">
              <Form.Label>비밀번호</Form.Label>
              <Form.Control
                type="password"
                name="password"
                value={formData.password}
                onChange={handleChange}
                required
              />
            </Form.Group>

            <Form.Group controlId="confirmPassword">
              <Form.Label>비밀번호 확인</Form.Label>
              <Form.Control
                type="password"
                name="confirmPassword"
                value={formData.confirmPassword}
                onChange={handleChange}
                required
              />
            </Form.Group>

            {/* 비밀번호 일치 여부 메시지 */}
            {!passwordMatch && (
              <Alert variant="danger">비밀번호와 비밀번호 확인이 일치하지 않습니다.</Alert>
            )}

            <Button variant="primary" type="submit">
              가입하기
            </Button>
          </Form>
        </Col>
      </Row>
    </Container>
  );
};

export default SignUpForm;
