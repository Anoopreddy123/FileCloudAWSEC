import React from "react";
import { Container, Row, Col, Image, Button, Card } from "react-bootstrap";
import Upload from "./Upload";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import { Link, useNavigate } from "react-router-dom";
export default function Body() {
  return (
    <>
      <Container className="d-flex flex-column justify-content-center align-items-center min-vh-90 mt-4">
        <div className="text-center">
          <h2>Filecloud</h2>
          <p className="mt-2">One stop destination for all the File Storage</p>
        </div>
      </Container>

      {/**********  Upload Section  **********/}

      <Container className="my-5 p-4">
        <Row className="g-3">
          <Col md={6} className="d-flex flex-column justify-content-between">
            <div>
              <h2>Upload</h2>
              <p>Very Simple and easy way to upload files</p>
            </div>
            <Button variant="dark" className="mt-4 align-self-start">
            <Nav.Link as={Link} to="/upload" className="ms-2">
                                  Click here
                                </Nav.Link>
            </Button>
          </Col>
          <Col md={4} className="d-flex align-items-center">
            <Image src="src/Assets/upload.png" alt="Upload" fluid />
          </Col>
        </Row>
      </Container>

      {/**********  Download Section  **********/}

      <Container className="my-5 p-4">
        <Row className="g-3">
          <Col md={6} className="d-flex flex-column justify-content-between">
            <div>
              <h2>Download</h2>
              <p>
                To download the file please continue to login and select the
                file.
              </p>
            </div>
            <Button variant="dark" className="mt-4 align-self-start">
              Click here
            </Button>
          </Col>
          <Col md={4} className="d-flex align-items-center">
            <Image src="src/Assets/upload.png" alt="Download" fluid />
          </Col>
        </Row>
      </Container>

      {/**********  More Info Section  **********/}

      <Container className="my-5 p-4">
        <h2>More Info</h2>
        <Row className="pt-3 g-4">
          <Col md={6}>
            <div>
              <i className="bi bi-lock"></i>
              <h6 className="pt-2">Privacy</h6>
              <p className="text-sm">
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas
                velit sapiente tempore? Aliquam vitae tempora animi nobis? Enim
                porro deserunt voluptatibus consequuntur asperiores repellendus
                eaque. Excepturi aperiam dolorem natus exercitationem.
              </p>
            </div>
          </Col>
          <Col md={6}>
            <div>
              <i className="bi bi-lock"></i>
              <h6 className="pt-2">Privacy</h6>
              <p className="text-sm">
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas
                velit sapiente tempore? Aliquam vitae tempora animi nobis? Enim
                porro deserunt voluptatibus consequuntur asperiores repellendus
                eaque. Excepturi aperiam dolorem natus exercitationem.
              </p>
            </div>
          </Col>
        </Row>


        <Row className="pt-5 g-4">
          <Col md={6}>
            <div>
              <i className="bi bi-lock"></i>
              <h6 className="pt-2">Privacy</h6>
              <p className="text-sm">
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas
                velit sapiente tempore? Aliquam vitae tempora animi nobis? Enim
                porro deserunt voluptatibus consequuntur asperiores repellendus
                eaque. Excepturi aperiam dolorem natus exercitationem.
              </p>
            </div>
          </Col>
          <Col md={6}>
            <div>
              <i className="bi bi-lock"></i>
              <h6 className="pt-2">Privacy</h6>
              <p className="text-sm">
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas
                velit sapiente tempore? Aliquam vitae tempora animi nobis? Enim
                porro deserunt voluptatibus consequuntur asperiores repellendus
                eaque. Excepturi aperiam dolorem natus exercitationem.
              </p>
            </div>
          </Col>
        </Row>
      </Container>


      {/**********  Footer Section  **********/}
     < Container className="my-5 p-4">
      <Card className="border border-white">
        <Card.Body>
          <Card.Title> <h2> Login to know more </h2> </Card.Title>
          <Card.Text>
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas
            velit sapiente tempore? Aliquam vitae tempora animi nobis? Enim
            porro deserunt voluptatibus consequuntur asperiores repellendus
            eaque. Excepturi aperiam dolorem natus exercitationem.
          </Card.Text>
          <Button variant="dark" className="d-flex justify-content-center">Login Now!</Button>
        </Card.Body>
      </Card>
       </Container>
    </>
  );
}
