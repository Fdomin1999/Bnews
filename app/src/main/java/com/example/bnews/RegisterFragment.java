//package com.example.bnews;
//
//
//            import android.os.Bundle;
//            import android.view.LayoutInflater;
//            import android.view.View;
//            import android.view.ViewGroup;
//            import android.widget.Button;
//            import android.widget.EditText;
//
//            import androidx.annotation.NonNull;
//            import androidx.fragment.app.Fragment;
//            import androidx.lifecycle.ViewModelProvider;
//            import androidx.lifecycle.ViewModelProviders;
//
//
//public class RegisterFragment extends Fragment{
//    rivate AutenticacionViewModel autenticacionViewModel;
//
//    private EditText nombreEditText, contrasenyaEditText, biografiaEditText;
//    private Button registrarButton;
//
//    public RegistroFragment() { }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_registro, container, false);
//    }
//
//    @Override
//    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        autenticacionViewModel = ViewModelProviders.of(requireActivity()).get(AutenticacionViewModel.class);
//
//        nombreEditText = view.findViewById(R.id.userEmail);
//        contrasenyaEditText = view.findViewById(R.id.edittext_contrasenya);
//        biografiaEditText = view.findViewById(R.id.edittext_biografia);
//        registrarButton = view.findViewById(R.id.button_registrar);
//
//        // Poner el estado del registro al estado INICIAR,
//        // (por si se habia quedado en COMPLETADO o NOMBRE_NO_DISPONIBLE)
//        autenticacionViewModel.iniciarRegistro();
//
//        registrarButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                autenticacionViewModel.crearCuentaEIniciarSesion(nombreEditText.getText().toString(), contrasenyaEditText.getText().toString(), biografiaEditText.getText().toString());
//            }
//        });
//
//        autenticacionViewModel.estadoDelRegistro.observe(getViewLifecycleOwner(), new Observer<EstadoDelRegistro>() {
//            @Override
//            public void onChanged(EstadoDelRegistro estadoDelRegistro) {
//                switch (estadoDelRegistro){
//                    case NOMBRE_NO_DISPONIBLE:
//                        Toast.makeText(getContext(), "NOMBRE DE USUARIO NO DISPONIBLE", Toast.LENGTH_SHORT).show();
//                        break;
//                }
//            }
//        });
//
//        autenticacionViewModel.estadoDeLaAutenticacion.observe(getViewLifecycleOwner(), new Observer<EstadoDeLaAutenticacion>() {
//            @Override
//            public void onChanged(EstadoDeLaAutenticacion estadoDeLaAutenticacion) {
//                switch (estadoDeLaAutenticacion){
//                    case AUTENTICADO:
//                        Navigation.findNavController(view).popBackStack();
//                        break;
//                }
//            }
//        });
//    }
//}
//
//
//    }
//            }