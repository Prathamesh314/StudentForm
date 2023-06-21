import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Container, Paper, Button } from '@mui/material';


export default function Student() {
    const paperStyle={padding:'50px 20px', width:600,margin:'20px auto'}
    const[name,setName]=React.useState('')
    const[address,setAddress]=React.useState('')
    const[student,setStudent]=React.useState([])
    const handleClick=(e)=>{
        e.preventDefault()
        const student={name,address}
        console.log(student)
        fetch("http://localhost:8081/student/add",
        {
            method:"POST",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify(student)
        }).then(()=>
        {console.log("New Student Added")})

    }
    React.useEffect(()=>{
        fetch("http://localhost:8081/student/find")
        .then(res=>res.json())
        .then((result)=>{
            setStudent(result);
        }
    )},[])
  return (
    <Container>
        <Paper elevation={3} style={paperStyle}>
            <form>
                <h1 style={{color:"blue"}}><u>Login Page</u></h1>
                <Box
                component="form"
                sx={{
                    '& > :not(style)': { m: 1 },
                }}
                noValidate
                autoComplete="off"
                >
                <TextField id="outlined-basic" label="Student Name" variant="outlined" fullWidth
                value={name}
                onChange={(e)=>setName(e.target.value)}
                />
                <TextField id="outlined-basic" label="Student Address" variant="outlined" fullWidth 
                value={address}
                onChange={(e)=>setAddress(e.target.value)}
                />
                </Box>
                <Button variant="contained" color="success" onClick={handleClick}>
                    Login
                </Button>
            </form>
        </Paper>
        <h1>Students List</h1>
        <Paper elevation={3} style={paperStyle}>
             {
                student.map(student=>
                    (<Paper elevation={6} style={{margin:"10px",padding:"15px",textAlign:"left"}} key={student.id}>
                        Id: {student.id}<br/>
                        Name: {student.name}<br/>
                        Address: {student.address}<br/>
                    </Paper>))
             }
        </Paper>
    </Container>
  );
}
