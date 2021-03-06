import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Badge } from 'reactstrap'
import { Container, Row, Col } from 'reactstrap';
import { Button } from 'reactstrap';

const styles = {
  container: {
      backgroundColor: 'rgb(220,220,220)',
      height: '80%'
  }
}

const Header = (props) =>  {
  return (
    <Container fluid style={styles.container}>
      <Row className="h-100">
          <Col xs = "3" className="align-self-center"><h1 className="h-100 float-left"><Badge color="secondary">TutorPro</Badge></h1></Col>
          <Col xs = "7"></Col>
          <Col xs = "2" className="align-self-center"><Button color="primary" onClick={props.logOut}>Log Out</Button></Col>
      </Row>
    </Container>
  );
}

export default Header