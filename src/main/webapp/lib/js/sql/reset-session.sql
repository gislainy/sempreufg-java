SELECT pg_terminate_backend(pid) 
   FROM pg_stat_activity 
  WHERE pid <> pg_backend_pid();

select pg_terminate_backend(procpid)
from pg_stat_activity
where datname = ‘nome_do_database’